package com.lxf.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

/**
 * 回压测试
 */
public class BackPressureDemo {
    public static void main(String[] args) {
        Flux.range(1, 6)//定义一个快的Publisher
                .doOnRequest(n -> System.out.println("Request " + n + "valus..."))//请求的时候做什么（例如打印请求的元素的个数）
                .subscribe(new BaseSubscriber<Integer>() {//自定义Subscriber
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {//订阅的时候执行的操作
                        System.out.println("Subscribed and make a request...");
                        request(1);//订阅时首先向上游请求一个元素
                    }

                    @Override
                    protected void hookOnNext(Integer value) {//收到一个元素后执行的操作
                        try {
                            TimeUnit.SECONDS.sleep(1);//sleep 1s来模拟慢的Subscriber
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("get value [" + value + "]");
                        request(1);//处理完一个元素再请求一个
                    }
                });
    }
}
