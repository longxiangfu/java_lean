package com.lxf.reactor;

import reactor.core.publisher.Flux;

/**
 * 研究Flux方法
 */
public class FluxTest {
    public static void main(String[] args) {
//        testGenerate();
        testCreate();
    }


    /**
     * 测试generate方法
     */
    private static void testGenerate(){
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);//在一次的Flux.generate方法调用中，只允许next一次，即一次只能产生一个元素
//            synchronousSink.next(2);//否则会报错 ava.lang.IllegalStateException: More than one call to onNext
            synchronousSink.complete();
        }).subscribe(System.out::println);

    }

    /**
     * 测试create方法
     */
    private static void testCreate(){
        Flux.create(fluxSink -> {//在一个的Flux.create方法调用中，next可以调用多次，即一次可以产生多个元素
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        }).subscribe(System.out::println);

    }

}
