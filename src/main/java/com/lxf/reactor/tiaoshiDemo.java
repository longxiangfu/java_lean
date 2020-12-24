package com.lxf.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

/**
 * reactor调试
 */
public class tiaoshiDemo {

    public static void main(String[] args) {
        test();
//        hooksTest();
//        checkPointTest();
//        logTest();
    }

    /**
     * 正常情况下打印错误信息。只打印Stack trace
     */
    private static void test(){
        Flux.generate(synchronousSink -> {
           synchronousSink.next(1);
           synchronousSink.next(2);
        }).subscribe(System.out::println);
    }

    /**
     * 使用Hooks.onOperatorDebug()开启调试模式
     * 除了Stack trace外，还打印出一些有用的信息
     * 这是全局性的Hook,会影响应用中所有的操作符，性能较低，这样打印出的调试信息也会非常多
     */
    private static void hooksTest(){
        Hooks.onOperatorDebug();
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            synchronousSink.next(2);
        }).subscribe(System.out::println);

    }

    /**
     * checkpoint:针对当前链进行调试
     * 如果我们大概知道问题出在某条链上，就可以用checkpoint
     */
    private static void checkPointTest(){
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            synchronousSink.next(2);
        })
                .checkpoint()
                .subscribe(System.out::println);

    }

    private static void logTest(){
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            synchronousSink.next(2);
        })
                .log()
                .subscribe(System.out::println);
    }
}
