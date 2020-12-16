package com.lxf.reactor;

import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.Random;

/**
 * 错误处理类
 */
public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
    private static final String TAG = "ErrorHandler";

    public static void main(String[] args) {
        test();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();

    }

    private static void test(){
        Flux.just(1, 2, 3, 4, 5, 6)
                .map(i -> {
                    System.out.println(Thread.currentThread().getName());
                    return 10/(i-3);
                })
                .map(i -> {
                    System.out.println(Thread.currentThread().getName());
                    return i*i;
                })
//                .subscribe(System.out::println, System.out::println);//将异常输出
//        25
//        100
//        java.lang.ArithmeticException: / by zero
                .subscribe(System.out::println);//直接将异常抛出
    }


    /**
     * 发生错误时返回一个缺省值，并且序列中后面的元素将不会被执行
     */
    private static void test1(){
        Flux.just(1, 2, 3, 4, 5, 6)
                .map(i -> 10/(i-3))
                .onErrorReturn(0)
                .map(i -> i*i)
//                .subscribe(System.out::println, System.out::println);
//        25
//        100
//        0
                .subscribe(System.out::println);
//        25
//        100
//        0
    }

    /**
     * 发生错误时用一个值来恢复，但后面的元素将不会被执行
     */
    private static void test2(){
        Flux.just(1, 2, 3, 4, 5, 6)
                .map(i -> 10/(i-3))
                .onErrorResume(e -> Mono.just(new Random().nextInt(10)))
                .map(i -> i*i)
                .subscribe(System.out::println, System.out::println);
//        25
//        100
//        64
//                .subscribe(System.out::println);
//        25
//        100
//        64
    }

    /**
     * 发生错误时，将错误包装成业务异常，并抛出
     */
    private static void test3(){
        try{
            Flux.just(1, 2, 3, 4, 5, 6)
                    .map(i -> 10/(i-3))
                    .onErrorMap(e -> new RuntimeException("计算时发生错误", e))
                    .map(i -> i*i)
                    .subscribe(System.out::println);//抛出异常
//                .subscribe(System.out::println, System.out::println);
//        25
//        100
//        java.lang.RuntimeException: 计算时发生错误
        }catch (Exception e){
            System.out.println("try...catch");
            e.printStackTrace();
        }
    }


    /**
     * 错误发生时，记录日志，然后继续抛出
     * 实验结果证明并没有抛出，因为并没有打印try...catch
     */
    private static void test4(){
        try {
            Flux.just(1, 2, 3, 4, 5, 6)
                    .map(i -> 10/(i-3))
                    .doOnError(e -> logger.error(TAG+" test4", e))//错误发生时做什么（比如记录日志），错误信号会继续向下游传递
                    .map(i -> i*i)
                    .subscribe(System.out::println);//抛出异常
//                .subscribe(System.out::println, System.out::println);//java.lang.ArithmeticException: / by zero
        }catch (Exception e){
            System.out.println("try...catch");
            e.printStackTrace();
        }
    }


    /**
     * doFinally根据终止事件类型，针对性的进行处理
     */
    private static void test5(){
        Flux.just("flux", "mono")
                .doFinally(signalType -> {
                    if (signalType == SignalType.ON_COMPLETE) {
                        System.out.println("正常完成后执行");
                    }
                })
                .subscribe(System.out::println);
//        flux
//        mono
//        正常完成后执行
    }
}
