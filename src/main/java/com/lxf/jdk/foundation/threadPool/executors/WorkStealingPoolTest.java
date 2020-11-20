package com.lxf.jdk.foundation.threadPool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、生成与逻辑cpu数相等的线程数的线程池
 * 2、发现一个有趣的现象:主线程停掉的话，其他线程也停掉了
 * 3、底层基于ForkJoinPool，其他的是基于ThreadPoolExecutor
 * 4、并行处理任务，不能保证任务的执行顺序，其他线程池可以保证任务的执行顺序
 */
public class WorkStealingPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(10);//测试任务的执行顺序
        for (int i = 0; i < 10; i++) {
            int finalNumber = i;
            executorService.execute(() -> {
                System.out.println("i：" + finalNumber);
            });
        }
        Thread.sleep(5000);
        System.out.println("我是主线程：" + Thread.currentThread().getName());


        //可以直接执行方法
        executorService.submit(WorkStealingPoolTest::doTask);
    }

    private static void doTask(){

    }
}
