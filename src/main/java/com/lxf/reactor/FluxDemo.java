package com.lxf.reactor;

public class FluxDemo {

	public static void main(String[] args) {
//		Flux.just("Hello", "World").subscribe(System.out::println);
//		Flux.fromArray(new Integer[] {1,2,3}).subscribe(System.out::println);
//		Flux.empty().subscribe(System.out::println);
//		Flux.range(2, 10).subscribe(System.out::println);
//		Flux.error(new Throwable("这是一个错误！")).subscribe(System.out::println);
//		Flux.never().subscribe(System.out::println);
//		System.out.println("-------");
//		Flux.intervalMillis(1000).subscribe(System.out.println());
//
//		/*
//		 * generate()：通过同步和逐一的方式来产生 Flux 序列
//		 */
//		Flux.generate(sink -> {
//			sink.next("Hello");
//			sink.next("word");//在具体的生成逻辑中（一次调用中），Flux对象的next()只能使用一次
//			sink.complete();
//		}).subscribe(System.out::println);
//
//		//for each incoming Subscriber to provide the initial state
//		final Random random = new Random();
//		Flux.generate(ArrayList::new, (list, sink) -> {
//			int value = random.nextInt(100);
//			list.add(value);
//			sink.next(value);
//			if(list.size() == 10) {
//				sink.complete();
//			}
//			return list;
//		}).subscribe(System.out::println);
//
//		//for each incoming Subscriber to provide the initial state
//		//release resources or do other cleanup
//		final Random random1 = new Random();
//		Flux.generate(ArrayList::new, (list1, sink1) -> {
//			int value = random1.nextInt(100);
//			list1.add(value);
//			sink1.next(value);
//			if(list1.size() == 10) {
//				sink1.complete();
//			}
//			return list1;
//		},list1 ->{
//			list1.clear();
//		}
//		).subscribe(System.out::println);
//
//		/*
//		 * create()：支持同步和异步的消息产生
//		 * 使用FluxSink对象的next(),可以在一次调用中生成多个元素
//		 * OverflowStrategy.BUFFER（背压模式:BUFFER等5种，默认BUFFER）, FluxCreate.CreateMode.PUSH_ONLY（Flux创建模式：PUSH_ONLY, PUSH_PULL，默认PUSH_ONLY）
//		 */
//		Flux.create(sink -> {
//			for(int i = 0; i < 10;i++) {
//				sink.next(i);
//			}
//			sink.complete();
//		}).subscribe(System.out::println);

	}

}
