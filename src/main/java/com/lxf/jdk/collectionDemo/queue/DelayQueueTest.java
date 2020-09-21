package com.lxf.jdk.collectionDemo.queue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DelayQueue:延迟队列,内部是基于PriorityQueue的
 * 创建元素时指定延时时间，只有到达延时时间，才能获取到该元素
 * 手动实现延迟消息队列
 */
public class DelayQueueTest {
    private static AtomicInteger MESSAGE_NO = new AtomicInteger(1);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        DelayQueue<Element> delayQueue = new DelayQueue();
        //生产者1
        produce("生产者1", delayQueue);
        //生产者2
        produce("生产者2", delayQueue);
        //消费者
        consume("消费者", delayQueue);
    }

    private static void consume(String consumer, DelayQueue<Element> delayQueue) {
        new Thread(() ->{
            while (true){
                try {
                    Element element = delayQueue.take();
                    System.out.println(element.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void produce(String producer, DelayQueue<Element> delayQueue) {
        new Thread(() ->{
            while (true){
                //延时时间 1～5s
                Random random = new Random();
                long delayTime = 1000 * (random.nextInt(5) + 1);
                try {
                    Thread.sleep(delayTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //消息
                String message = String.format("%s，消息编号：%s，发送时间：%s，延迟时间：%s秒",
                        producer, MESSAGE_NO.getAndIncrement(), formatter.format(LocalDateTime.now()), delayTime);
                delayQueue.put(new Element(message, delayTime));
            }

        }).start();

    }


    private static class Element implements Delayed {
        private String message;
        private long timeMillis = System.currentTimeMillis();

        public Element(String message, long delayTime){
            this.message = message;
            timeMillis += delayTime;
        }

        /**
         * 获取元素剩余延迟时间
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(timeMillis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
//            return timeMillis - System.currentTimeMillis();
        }

        /**
         * 元素时间比较
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            }else if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)){
                return -1;
            }else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return message + "。执行时间：" + formatter.format(LocalDateTime.now());
        }
    }
}
