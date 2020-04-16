package com.lxf.reactor;

import reactor.core.publisher.Flux;

/**
 * 演示:reactor生产者消费者一对一（生产者和消费者是同一个线程）
 * @author longxiangfu
 * 
 */
public class ReactorSample3 {	
	public static void main(String[] args) {
		Flux<String> flux = Flux.<String>create(sink->sink.onRequest(l->{
			System.err.println(l);
			for(int i=0;i<50;i++) {
				sink.next("Product生产的第"+i+"个商品（生产此商品的线程为："+Thread.currentThread().getName()+")");
				sink.complete();//生产出第一个消息就结束该序列
			}
		}));
		
		flux.subscribe(e->System.out.println("Consumer1  消费了"+e+"此时消费者的线程为："+Thread.currentThread().getName()));		
	}
}
