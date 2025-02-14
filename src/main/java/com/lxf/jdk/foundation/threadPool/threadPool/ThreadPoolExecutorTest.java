package com.lxf.jdk.foundation.threadPool.threadPool;

import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadPoolExecutor基本使用
 * 1、基本用法，参数
 * 2、工作队列：阻塞任务将进入该队列中，但是只针对execute的方法的，submit阻塞的任务不进入队列中
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2),
                new MyThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.allowCoreThreadTimeOut(true); // 设置允许核心线程超时
        //测试submit时，阻塞线程是否进入到队列中，答案否
        new Thread(() ->{
            BlockingQueue<Runnable> queue = executor.getQueue();
            Iterator<Runnable> iterator = queue.iterator();
            while (iterator.hasNext()){
                System.out.println("阻塞队列中有任务");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            executor.execute(() ->{//submit
                System.out.println("当前线程名称：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static class MyThreadFactory implements ThreadFactory {
        private AtomicInteger count = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            String threadName = "my thread-" + count.addAndGet(1);
            thread.setName(threadName);
            return thread;
        }
    }

}
