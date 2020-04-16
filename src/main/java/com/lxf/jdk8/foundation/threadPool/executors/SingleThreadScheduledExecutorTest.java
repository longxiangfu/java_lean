package com.lxf.jdk8.foundation.threadPool.executors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 1、单核心线程计划任务线程池
 * 2、最大线程数是Integer.MAX_VALUE,容易造成内存溢出
 */
public class SingleThreadScheduledExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        singleThreadScheduledExecutor.scheduleAtFixedRate(() ->{
            System.out.println("当前线程：" + Thread.currentThread().getName() +
                    " 当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        }, 1, 1, TimeUnit.SECONDS);
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 15:10:52:610
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 15:10:53:578
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 15:10:54:578

    }
}
