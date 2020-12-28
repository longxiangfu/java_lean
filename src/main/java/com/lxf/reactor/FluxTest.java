package com.lxf.reactor;

import reactor.core.Disposable;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 研究Flux方法
 */
public class FluxTest {
    public static void main(String[] args) throws InterruptedException {
//        testGenerate();
//        testCreate();
//        hotConnect();
//        hotAutoConnect();
        hotRefConnect();
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


    /**
     * 演示热序列管理方式：connect
     * 手动触发   类似CyclicBarriar栅栏
     */
    private static void hotConnect() throws InterruptedException {
        Flux<Integer> source = Flux.range(1, 3).doOnSubscribe(s -> System.out.println("上游收到订阅"));
        ConnectableFlux<Integer> connectableFlux = source.publish();
        connectableFlux.subscribe(System.out::println, e -> {}, () -> {});
        connectableFlux.subscribe(System.out::println, e -> {}, () -> {});
        System.out.println("订阅者完成订阅");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("还没有连接上");
        connectableFlux.connect();//手动触发
//        订阅者完成订阅
//        还没有连接上
//        上游收到订阅
//        1
//        1
//        2
//        2
//        3
//        3
    }

    /**
     * 演示热序列管理方式：Autoconnect
     * autoConnect(n)有n个订阅者后自动触发  类似CyclicBarriar栅栏
     */
    private static void hotAutoConnect() throws InterruptedException {
        Flux<Integer> source = Flux.range(1, 3).doOnSubscribe(s -> System.out.println("上游收到订阅"));
        Flux<Integer> autoCo = source.publish().autoConnect(2);//需要两个订阅者才能自动连接
        System.out.println("第一个订阅者完成订阅操作");
        autoCo.subscribe(System.out::println);
        Thread.sleep(500);
        System.out.println("第二个订阅者完成订阅操作");
        autoCo.subscribe(System.out::println);
    }

    /**
     * 演示热序列管理方式：Refconnect   类似CyclicBarriar栅栏
     * refCount(n, Duration.ofSeconds(m)):n个订阅者后自动触发，当订阅者数量不足n时，若超时m秒后，发布者将断开连接，
     * 直到再次有足够的订阅者，若在超时时间m秒内订阅者达到，将继续发布元素
     */
    private static void hotRefConnect() throws InterruptedException {
        Flux<Long> source = Flux.interval(Duration.ofMillis(500))
                .doOnSubscribe(s -> System.out.println("上游收到订阅"))
                .doOnCancel(() -> System.out.println("上游发布者断开连接"));
        Flux<Long> refCounted = source.publish().refCount(2, Duration.ofSeconds(2));
        System.out.println("第一个订阅者订阅");
        Disposable sub1 = refCounted.subscribe(l -> System.out.println("sub1: " + l));

        TimeUnit.SECONDS.sleep(1);
        System.out.println("第二个订阅者订阅");
        Disposable sub2 = refCounted.subscribe(l -> System.out.println("sub2: " + l));

        TimeUnit.SECONDS.sleep(1);
        System.out.println("第一个订阅者取消订阅");
        sub1.dispose();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("第二个订阅者取消订阅");
        sub2.dispose();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("第三个订阅者订阅");
        Disposable sub3 = refCounted.subscribe(l -> System.out.println("sub3: " + l));

        TimeUnit.SECONDS.sleep(1);
        System.out.println("第三个订阅者取消订阅");
        sub3.dispose();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("第四个订阅者订阅");
        Disposable sub4 = refCounted.subscribe(l -> System.out.println("sub4: " + l));
        TimeUnit.SECONDS.sleep(1);
        System.out.println("第五个订阅者订阅");
        Disposable sub5 = refCounted.subscribe(l -> System.out.println("sub5: " + l));
        TimeUnit.SECONDS.sleep(2);
//        第一个订阅者订阅
//                第二个订阅者订阅
//        上游收到订阅
//        sub1: 0
//        sub2: 0
//        第一个订阅者取消订阅
//        sub2: 1
//        sub2: 2
//        sub2: 3
//        第二个订阅者取消订阅
//                第三个订阅者订阅
//        sub3: 4
//        sub3: 5
//        sub3: 6
//        sub3: 7
//        第三个订阅者取消订阅
//        上游发布者断开连接
//        第四个订阅者订阅
//        第五个订阅者订阅
//        上游收到订阅
//        sub4: 0
//        sub5: 0
//        sub4: 1
//        sub5: 1
//        sub4: 2
//        sub5: 2


    }

}
