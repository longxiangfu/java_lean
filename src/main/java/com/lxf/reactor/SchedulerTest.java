package com.lxf.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * 调度器测试
 * 响应式流：具有异步非阻塞的流。未通过publishOn或subscribeOn指定线程的，都是由主线程执行，即同步执行。
 * 可以通过publishOn或subscribeOn指定别的线程运行，达到异步非阻塞的目的
 */
public class SchedulerTest {
    public static void main(String[] args) {
        test();
//        test1();
    }

    private static void test1() {
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
        .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
        .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
        .toStream()
        .forEach(System.out::println);//[main] [main] main
    }

    private static void test() {
        Flux.create(sink -> {
			sink.next(Thread.currentThread().getName());
			sink.complete();
		})
		.publishOn(Schedulers.parallel())//切换的是下一些map操作符的执行方式
		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
		.publishOn(Schedulers.elastic())//切换的是下一个map操作符的执行方式
		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
		.subscribeOn(Schedulers.single())//切换的是产生流中元素时的执行方式
		.toStream()//将Fulx转换为jdk8的Stream
		.forEach(System.out::println);//[elastic-2] [parallel-1] single-1
    }
}
