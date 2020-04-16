package com.lxf.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ReactorSample6 {
	

	public static void main(String[] args) {
		
		Scheduler s = Schedulers.elastic();
		Flux<String> flux = Flux.<String>create(sink->sink.onRequest(l->{
			System.err.println(l);//此处的l是什么意思
			for(int i=0;i<266;i++) {
				sink.next("Product生产的第"+i+"个商品（生产此商品的线程为："+Thread.currentThread().getName()+")");
			}
			sink.complete();
		})).subscribeOn(s).publishOn(s);//生产和消费不在同一个线程
		
		flux.subscribe(e->System.out.println("Consumer1  消费了"+e+"此时消费者的线程为："+Thread.currentThread().getName()));
		while(true) {
			
		}
		
	}
	
}
