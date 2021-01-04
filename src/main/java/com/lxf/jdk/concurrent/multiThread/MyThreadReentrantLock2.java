package com.lxf.jdk.concurrent.multiThread;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition实现生产者消费者模式
 */
public class MyThreadReentrantLock2 {
    private LinkedList<Object> buffer;//队列
    private int maxSize;//队列最大容量
    private Lock lock;//并发锁
    private Condition existCondition;//队列中有元素的条件
    private Condition notFullCondition;//队列没满的条件

    public MyThreadReentrantLock2(int maxSize){
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        existCondition = lock.newCondition();
        notFullCondition = lock.newCondition();

    }


    /**
     * 生产者  发出元素
     */
    public void publish(Object object){
        lock.lock();
        try {
            while (maxSize == buffer.size()){
                //队列已经满了，等待队列不满
                System.out.println("生产者发出信号：队列已经满了，等待队列不满");
                notFullCondition.await();
            }
            buffer.add(object);
            System.out.println("生产者添加一个元素");
            //发出：队列已经有元素了
            if (buffer.size() == 1) {
                System.out.println("生产者发出信号：队列已经有元素了");
                existCondition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


    /**
     * 消费者 消费元素
     */
    public void consume(){
        lock.lock();
        try {
            while (buffer.size() == 0){
                //队列为空，等待队列中有元素
                System.out.println("队列为空，等待队列中有元素。当前消费者线程进入等待状态");
                existCondition.await();
            }
            buffer.poll();
            System.out.println("消费者消费一个元素");
            //发出信号：队列已经不满了
            if (maxSize-1 == buffer.size()) {
                System.out.println("消费者发出信号：队列已经不满了");
                notFullCondition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Random random = new Random();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        MyThreadReentrantLock2 myCase = new MyThreadReentrantLock2(10);
        //生产快消费慢
//        service.scheduleAtFixedRate(() -> {
//            myCase.publish(random.nextInt(100));
//        }, 1, 1, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(() -> {
//            myCase.consume();
//        }, 1, 2, TimeUnit.SECONDS);

        //消费快生产慢
        service.scheduleAtFixedRate(() -> {
            myCase.publish(random.nextInt(100));
        }, 1, 2, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> {
            myCase.consume();
        }, 1, 1, TimeUnit.SECONDS);
    }


}
