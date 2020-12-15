//package com.lxf.reactor;
//
//import reactor.core.publisher.Flux;
//import reactor.core.scheduler.Schedulers;
//
///**
// * 演示:reactor生产者消费者一对多
// * @author longxiangfu
// *
// */
//public class ReactorSample4 {
//
//	public static void main(String[] args) {
//		Flux<String> flux = Flux.<String>create(sink->sink.onRequest(l->{
//			System.err.println(l);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e1) {
//
//			}
//			for(int i=0;i<192;i++) {
//				sink.next("Product生产的第"+i+"个商品（生产此商品的线程为："+Thread.currentThread().getName()+")");
//			}
//		})).publishOn(Schedulers.elastic(),192);//消费转到别的线程，开始时生产和消费线程不一样，后来生产线程转到消费的线程上了
//
//		flux.subscribe(e->System.out.println("Consumer1  消费了"+e+"此时消费者的线程为："+Thread.currentThread().getName()));
//
//		while(true) {
//
//		}
//	}
//
//}
