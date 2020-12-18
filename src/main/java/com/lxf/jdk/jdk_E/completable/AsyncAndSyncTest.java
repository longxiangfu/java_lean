package com.lxf.jdk.jdk_E.completable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * 以Async和不以Async结尾的方法的区别
 * 1、以Async结尾的：就是去线程池中拿一个空线程或新启一个线程去执行
 * 2、不以Async结尾的：本例中有说明
 *
 * 参照：https://blog.csdn.net/leon_wzm/article/details/80560081
 */
public class AsyncAndSyncTest {

    private static final Logger logger = LoggerFactory.getLogger(AsyncAndSyncTest.class);


    public static void main(String[] args) throws IOException {
        //不以Async结尾，主线程执行
//        test1();
//        //不以Async结尾，其他线程执行
        test2();
    }

    private static void test1() throws IOException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();

        new Thread(() -> {
            // 子线程A启动
            logger.info("子线程A启动" + Thread.currentThread().getName());
            try {
                logger.info("子线程A沉睡5s");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("子线程A令future完成");
            f.complete(100);  // 当子线程A执行到f.complete的时候，会去看是否有注册好的f的then或者when（非async的），如果有的话，会顺次去执行。
            logger.info("子线程A结束");
        }).start();


        // 当前线程（主线程）执行到这里的时候，如果子线程还没有执行到f.complete(100)，
        // 那么当前线程会把whenComplete事件注册起来，并且说好如果哪个线程执行了f.complete(100)，
        // 哪个线程就负责执行whenComplete的内容。
        // 如果当前线程（主线程）执行到这里的时候，f.complete(100)已经被其他线程执行完毕了。
        // 那么只有当前线程自己来执行whenComplete里面的内容了。
        f.whenComplete((i, ex) -> {
            // 这个场景下，whenComplete的回调的执行线程会是子线程A
            logger.info("do something after complete begin");
            try {
                logger.info("沉睡10s");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("do something after complete end");
        });

        logger.info("main over");
        System.in.read();
//        2020-12-18 15:10:56.461 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:59  - main over
//        2020-12-18 15:10:56.461 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:29  - 子线程A启动Thread-0
//        2020-12-18 15:10:56.466 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:31  - 子线程A沉睡5s
//        2020-12-18 15:11:01.467 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:36  - 子线程A令future完成
//        2020-12-18 15:11:01.467 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:49  - do something after complete begin
//        2020-12-18 15:11:01.467 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:51  - 沉睡10s
//        2020-12-18 15:11:11.467 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:56  - do something after complete end
//        2020-12-18 15:11:11.469 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:38  - 子线程A结束
    }

    private static void test2() throws IOException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();

        new Thread(() -> {
            // 子线程A启动
            logger.info("子线程A启动");
            try {
                logger.info("子线程A沉睡5s");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("子线程A令future完成");
            f.complete(100);  // 当子线程A执行到f.complete的时候，会去看是否有注册好的f的then或者when（非async的），如果有的话，会顺次去执行。
            logger.info("子线程A结束");
        }).start();


        // 当前线程（主线程）执行到这里的时候，如果子线程还没有执行到f.complete(100)，
        // 那么当前线程会把whenComplete事件注册起来，并且说好哪个线程执行了f.complete(100)，
        // 哪个线程就负责执行whenComplete的内容。
        // 如果当前线程（主线程）执行到这里的时候，f.complete(100)已经被其他线程执行完毕了。
        // 那么只有当前线程自己来执行whenComplete里面的内容了。

        try {
            logger.info("主线程沉睡10s");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        f.whenComplete((i, ex) -> {
            // 这个场景下，whenComplete的回调的执行线程会是主线程
            logger.info("do something after complete begin");
            try {
                logger.info("沉睡10s");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            logger.info("do something after complete end");
        });


        logger.info("main over");
        System.in.read();
    }
//    2020-12-18 15:11:45.380 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:96  - 主线程沉睡10s
//2020-12-18 15:11:45.380 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:76  - 子线程A启动
//2020-12-18 15:11:45.385 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:78  - 子线程A沉睡5s
//2020-12-18 15:11:50.385 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:83  - 子线程A令future完成
//2020-12-18 15:11:50.385 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:85  - 子线程A结束
//2020-12-18 15:11:55.387 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:104 - do something after complete begin
//2020-12-18 15:11:55.387 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:106 - 沉睡10s
//2020-12-18 15:12:05.388 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:112 - do something after complete end
//2020-12-18 15:12:05.388 INFO  com.lxf.jdk.jdk_E.completable.AsyncAndSyncTest Line:116 - main over
}
