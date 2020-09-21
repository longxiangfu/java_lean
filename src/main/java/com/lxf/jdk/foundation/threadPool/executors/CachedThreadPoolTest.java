package com.lxf.jdk.foundation.threadPool.executors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、任务多少就创建多少线程，并将线程缓存下来
 * 2、创建的最大线程数是Integer.MAX_VALUE,容易造成内存溢出
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(() ->{
                System.out.println("当前线程：" + Thread.currentThread().getName() +
                        " 当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        当前线程：pool-1-thread-7 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-2 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-6 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-9 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-5 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-4 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-3 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-10 当前时间：2020-03-12 11:39:44:427
//        当前线程：pool-1-thread-8 当前时间：2020-03-12 11:39:44:427
    }
}
