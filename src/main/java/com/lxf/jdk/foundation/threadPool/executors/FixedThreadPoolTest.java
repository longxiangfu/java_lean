package com.lxf.jdk.foundation.threadPool.executors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、创建固定数量线程池，用于控制最大并发数
 * 2、任务队列容量是Integer.MAX_VALUE,容易造成oom
 */
public class FixedThreadPoolTest {
    private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(() ->{
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 当前时间：" + FORMAT.format(LocalDateTime.now()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        当前线程：pool-1-thread-2 当前时间：2020-03-12 11:48:57:556
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 11:48:57:556
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 11:48:58:560
    }
}
