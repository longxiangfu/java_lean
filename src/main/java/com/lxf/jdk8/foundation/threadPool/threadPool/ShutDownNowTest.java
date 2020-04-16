package com.lxf.jdk8.foundation.threadPool.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * shutdownNow后：
 * 1、线程池状态变为stop
 * 2、不再接受新的任务
 * 3、尝试终止正在运行的线程，若被终止(sleep时)，会抛出异常InterruptedException
 */
public class ShutDownNowTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100),
                 new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.allowCoreThreadTimeOut(true);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println("I：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executor.shutdownNow();
        System.out.println("Java");
        executor.execute(() -> {
            System.out.println("I'm Java.");//不输出
        });
    }
}
