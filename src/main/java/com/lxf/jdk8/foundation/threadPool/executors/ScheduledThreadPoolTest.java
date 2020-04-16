package com.lxf.jdk8.foundation.threadPool.executors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 1、计划任务的线程池
 * 2、最大线程数量为Integer.MAX_VALUE,容易造成内存溢出
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
//        scheduledThreadPool.schedule(() ->{
//            System.out.println("当前线程：" + Thread.currentThread().getName() +
//                    " 当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
//        }, 1L, TimeUnit.SECONDS);
//        System.out.println("时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
//        时间：2020-03-12 12:16:06:899
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 12:16:07:867

        scheduledThreadPool.scheduleAtFixedRate(() ->{
            System.out.println("当前线程：" + Thread.currentThread().getName() +
                    " 当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        }, 1, 2, TimeUnit.SECONDS);
        System.out.println("时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
//        时间：2020-03-12 12:22:09:878
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 12:22:10:850
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 12:22:12:849
//        当前线程：pool-1-thread-2 当前时间：2020-03-12 12:22:14:850
//        当前线程：pool-1-thread-2 当前时间：2020-03-12 12:22:16:849

    }
}
