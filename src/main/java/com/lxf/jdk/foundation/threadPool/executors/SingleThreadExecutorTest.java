package com.lxf.jdk.foundation.threadPool.executors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、单线程线程池
 * 2、任务队列容量是Integer.MAX_VALUE,容易造成内存溢出
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            singleThreadExecutor.execute(() ->{
                System.out.println("当前线程：" + Thread.currentThread().getName() +
                        " 当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 11:52:46:858
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 11:52:47:873
//        当前线程：pool-1-thread-1 当前时间：2020-03-12 11:52:48:873
    }
}
