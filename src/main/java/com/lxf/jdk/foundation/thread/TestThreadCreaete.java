package com.lxf.jdk.foundation.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程创建的3种方式
 */
public class TestThreadCreaete {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();

//        MyRunnable myRunnable = new MyRunnable();
//        new Thread(myRunnable).start();

        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        System.out.println("主线程："+ Thread.currentThread().getName());

    }
}
