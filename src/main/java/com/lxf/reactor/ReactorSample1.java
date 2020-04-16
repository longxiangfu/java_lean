package com.lxf.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class ReactorSample1 {
	
	public static void main(String[] args) {
		
		//这段代码只是演示一下Flux Mono的使用。
		//这段代码完全是单线程。
		//这段代码也完全没有业务意义
	
		//首先用熟悉的代码（① ② ）表达一下演示代码想要做的事情
		//③④ ⑤⑥ 是演示的代码
		List<String> fluxList = Arrays.asList("One", "Two", "Three");//①  一般来讲生产这是个运行着的，随时生产商品的生产者。但这个地方可以理解为，声明一个已经生产完成3个商品的不在继续生产的生成者。
		fluxList.forEach(n -> System.out.println(n));//② 这个地方可以理解为，循环消费商品。
		
		System.out.println();//换行打印
		Flux<String> flux = Flux.just("One","Two","THree","Four","Five");//③理解同①，Flux可以发布0-n个元素（事件） 生产者已经生产完数据了。
		flux.subscribe(System.out::println);//④理解同②   消费者注册订阅
		
		System.out.println();
		Mono<String> mono = Mono.just("One");//⑤理解同①，Flux可以发布0-n个元素（事件）
		mono.subscribe(System.out::println);//⑥理解同②
		
		//注意，目前演示的代码，生产和消费都在同一线程。
		
	}
	
}
