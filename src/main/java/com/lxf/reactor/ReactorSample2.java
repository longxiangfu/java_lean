package com.lxf.reactor;

import reactor.core.publisher.Flux;

/**
 * 演示:reactor生产者消费者一对一（生产者和消费者是同一个线程）
 * @author longxiangfu
 *
 */
public class ReactorSample2 {
	
	public static void main(String[] args) {
		/**
		 * 9223372036854775807
			-----------0
			Consumer1 消费了Product生产的第0个商品（生产此商品的线程为：main)，此时消费者的线程为：main
			-----------1
			Consumer1 消费了Product生产的第1个商品（生产此商品的线程为：main)，此时消费者的线程为：main
			-----------2
			Consumer1 消费了Product生产的第2个商品（生产此商品的线程为：main)，此时消费者的线程为：main
			-----------3
			Consumer1 消费了Product生产的第3个商品（生产此商品的线程为：main)，此时消费者的线程为：main
			-----------4
			Consumer1 消费了Product生产的第4个商品（生产此商品的线程为：main)，此时消费者的线程为：main
		 */
		
//		Flux<String> flux = Flux.<String>create(new Consumer<FluxSink<String>>() {
//			@Override
//			public void accept(FluxSink<String> t) {
//				t.onRequest(new LongConsumer() {
//					@Override
//					public void accept(long value) {
//						System.err.println(value);
//						for(int i=0;i<5;i++) {
//							System.err.println("-----------"+i);
//							t.next("Product生产的第"+i+"个商品（生产此商品的线程为："+Thread.currentThread().getName()+")");
//						}
//					}
//					
//				});
//			}
//			
//		});
		
		Flux<String> flux = Flux.<String>create(sink->sink.onRequest(l->{
		System.err.println(l);
		for(int i=0;i<5;i++) {
			System.err.println("-----------"+i);
			sink.next("Product生产的第"+i+"个商品（生产此商品的线程为："+Thread.currentThread().getName()+")");
		}
	}));
		
		flux.subscribe(e->System.out.println("Consumer1 消费了"+e+"，此时消费者的线程为："+Thread.currentThread().getName()));
	}
	
}
