package com.lxf.jdk.jdk_E.completable;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 同AsyncAndSyncTest
 */
public class AsyncAndSyncTest2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        test1();
//        test2();
//        test3();
    }


    private static void test1() throws IOException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();
        f.runAsync(() -> {
            System.out.println("线程A：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.complete(100);//注意：如果将该语句删除，“线程B：main”将不会被打印
            System.out.println("线程A执行完成");
        });
        f.thenRun(() -> System.out.println("线程B：" + Thread.currentThread().getName()));
        System.out.println("线程C：" + Thread.currentThread().getName());
        System.in.read();
//        线程A：ForkJoinPool.commonPool-worker-1
//        线程C：main
//        线程B：ForkJoinPool.commonPool-worker-1
//        线程A执行完成
    }

    private static void test2() throws IOException, InterruptedException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();
        f.runAsync(() -> {
            System.out.println("线程A：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.complete(100);//注意：如果将该语句删除，“线程B：main”将不会被打印
            System.out.println("线程A执行完成");
        });
        TimeUnit.SECONDS.sleep(5);//主线程阻塞
        f.thenRun(() -> System.out.println("线程B：" + Thread.currentThread().getName()));
        System.out.println("线程C：" + Thread.currentThread().getName());
        System.in.read();
//        线程A：ForkJoinPool.commonPool-worker-1
//        线程A执行完成
//        线程B：main
//        线程C：main
    }


    private static void test3() throws IOException {
        CompletableFuture.runAsync(() ->{//内部相当于默认调用了CompletableFuture#complete
            System.out.println("线程A：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程A执行完成");
        })
        .thenRun(() ->System.out.println("线程B：" + Thread.currentThread().getName()));
        System.out.println("线程C：" + Thread.currentThread().getName());
        System.in.read();
//        线程A：ForkJoinPool.commonPool-worker-1
//        线程C：main
//        线程A执行完成
//        线程B：ForkJoinPool.commonPool-worker-1
    }

}
