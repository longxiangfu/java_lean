package com.lxf.jdk.foundation.threadPool.threadPool;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor
 */
public class ScheduledThreadPoolExecutorTest {
    // ScheduledThreadPoolExecutor方法丰富,可以计划执行，可以设置线程池，可以查看线程池和线程信息
    private ScheduledExecutorService executor;


    ScheduledThreadPoolExecutorTest() {
        executor = new ScheduledThreadPoolExecutor(5, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            thread.setName("lxf");
            return thread;
        });
        executor.schedule(new BeatTask(), 0, TimeUnit.MILLISECONDS);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class BeatTask implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("1111");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                // 达到目的：以一定频率执行任务，当然也可以用ScheduledThreadPoolExecutor的重载方法实现
                executor.schedule(this, 1, TimeUnit.SECONDS);
            }
        }
    }


    public static void main(String[] args) {
        ScheduledThreadPoolExecutorTest test = new ScheduledThreadPoolExecutorTest();
    }


}
