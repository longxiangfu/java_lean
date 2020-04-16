package com.lxf.jdk8.foundation.threadPool.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * shutdown后：
 * 1、线程池状态变为shutdown
 * 2、线程池不再接受新的任务
 * 3、线程池会等待队列中的任务都执行完之后才终止
 */
public class ShutDownTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100),
                 new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.allowCoreThreadTimeOut(true);
        executor.execute(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println("I'm " + i);
                try {
                    Thread.sleep(1000);//sleep interrupted
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        executor.shutdown();
        executor.execute(() -> {
            System.out.println("I'm Java.");//不输出
        });
//        I'm 0
//        I'm 1
    }
}
