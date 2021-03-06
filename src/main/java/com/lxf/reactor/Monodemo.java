package com.lxf.reactor;

import com.sun.javafx.scene.SceneHelper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Monodemo {

	public static void main(String[] args) throws InterruptedException {
//		Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
//		Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
//		Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);


		/*------------------操作符----------------------*/
		/**
		 * 操作符之buffer\bufferTimeout
		 * 这两个操作符的作用是把当前流中的元素收集到集合中，并把集合对象作为流中的新元素
		 */
		//输出的是 5 个包含 20 个元素的数组
//		Flux.range(1, 100).buffer(20).subscribe(System.out::println);
//		//输出的是 5 个包含 2 个元素的数组。每当遇到一个偶数就会结束当前的收集
//		Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
////		输出的是 5 个包含 1 个元素的数组，数组里面包含的只有偶数
//		Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
//		/**
//		 * filter 对流中包含的元素进行过滤，只留下满足 Predicate 指定条件的元素
//		 * 输出的是 1 到 10 中的所有偶数
//		 */
//		Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
//		/**
//		 * window window 操作符的作用类似于 buffer，所不同的是 window 操作符是把当前流中的元素收集到另外的 Flux 序列中，因此返回值类型是 Flux<Flux<T>>
//		 *结果是 5个UnicastProcessor 字符
//		 */
//		Flux.range(1, 100).window(20).subscribe(System.out::println);
//		/**
//		 * zipWith zipWith 操作符把当前流中的元素与另外一个流中的元素按照一对一的方式进行合并.
//		 * 合并时可以不做任何处理，由此得到的是一个元素类型为 Tuple2 的流；也可以通过一个 BiFunction
//		 *  函数对合并的元素进行处理，所得到的流的元素类型为该函数的返回值。
//		 */
//		Flux.just("a", "b").zipWith(Flux.just("c", "d")).subscribe(System.out::println);
//		Flux.just("a", "b").zipWith(Flux.just("c", "d"), (s1 ,s2) -> String.format("%s-%s", s1, s2)).subscribe(System.out::println);
//		/**
//		 * take 从当前流中提取元素
//		 */
//		Flux.range(1, 1000).take(10).subscribe(System.out::println);
//		Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
//		Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
//		Flux.range(1, 1000).takeUntil(i -> i ==10).subscribe(System.out::println);
//		/**
//		 * reduce reduceWith  对流中包含的所有元素进行累积操作，得到一个包含计算结果的 Mono 序列
//		 */
//		Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
//		Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);
//
		/*------------------消息处理----------------------*/
		/**
		 * 下示例subscribe()方法同时处理了正常消息和错误消息
		 */
//		Flux.just(1, 2)
//		.concatWith(Mono.error(new IllegalStateException()))
//		.subscribe(System.out::println, System.err::println);
////		1
////		2
////		java.lang.IllegalStateException
//		Flux.just(1, 2)
//		.concatWith(Mono.error(new IllegalStateException()))
//		.onErrorReturn(0)
//		.subscribe(System.out::println);
////		1
////		2
////		0
//		Flux.just(1, 2)
//		.concatWith(Mono.error(new IllegalStateException()))
//		.subscribe(System.out::println);//抛出异常
//		Flux.just(1, 2)
//		.concatWith(Mono.error(new IllegalStateException()))
//		.retry(1)
//		.subscribe(System.out::println);

//		/*------------------调度器----------------------*/
//		/**
//		 * 通过调度器（Scheduler）可以指定反应式流操作执行的方式和所在的线程。多线程并发调度
//		 * 不使用调度器的普通的操作符本身就是异步非阻塞的，这种异步非阻塞基于操作系统的异步非阻塞线程模型
//		 * 使用调度器后，只是操作符对应的操作运行在不同于http线程的另外的工作线程上，底层还是基于操作系统的异步非阻塞
//		 */
//		Flux.create(sink -> {
//			sink.next(Thread.currentThread().getName());
//			sink.complete();
//		})
//		.publishOn(Schedulers.parallel())//切换的是下一个map操作符的执行方式
//		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//		.publishOn(Schedulers.elastic())//切换的是下一个map操作符的执行方式
//		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//		.subscribeOn(Schedulers.single())//切换的是产生流中元素时的执行方式
//		.toStream()//将Fulx转换为jdk8的Stream
//		.forEach(System.out::println);//[elastic-2] [parallel-1] single-1
//		Flux.create(fluxSink -> {
//			fluxSink.next(Thread.currentThread().getName());
//			fluxSink.complete();
//		}).subscribe(System.out::println);//main
//		Flux.create(fluxSink -> {
//			fluxSink.next(Thread.currentThread().getName());
//			fluxSink.complete();
//		}).subscribeOn(Schedulers.single())
//				.toStream()
//				.forEach(System.out::println);//single-1   subscribeOn无论出现在什么位置，只影响源头的执行环境
//		testSyncToAsync();
//		Flux.just(Thread.currentThread().getName())
//		.publishOn(Schedulers.parallel())//切换的是下一个map操作符的执行方式
//		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//		.publishOn(Schedulers.elastic())//切换的是下一个map操作符的执行方式
//		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//		.subscribeOn(Schedulers.single())//切换的是产生流中元素时的执行方式
//		.toStream()
//		.forEach(System.out::println);//[elastic-2] [parallel-1] single-1


//		/*------------------测试 单元测试 测试关注于每个数据元素----------------------*/
//		//测试版本和core冲突，没有找到合适的版本
//		StepVerifier.create(Flux.just("a", "b"))
//		.expectNext("a").expectNext("b").verifyComplete();
//
//		/*------------------日志----------------------*/
//		Flux.range(1, 2).log("Range").subscribe(System.out::println);
////		2020-12-18 11:23:59.179 INFO  Range Line:274 - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
////		2020-12-18 11:23:59.190 INFO  Range Line:274 - | request(unbounded)
////		2020-12-18 11:23:59.191 INFO  Range Line:274 - | onNext(1)
////		1
////		2020-12-18 11:23:59.192 INFO  Range Line:274 - | onNext(2)
////		2
////		2020-12-18 11:23:59.193 INFO  Range Line:274 - | onComplete()
//
//		/*------------------“冷”与“热”序列----------------------*/
		//按时间产生的序列，订阅者只能获取到订阅之后的数据
		final Flux<Long> source = Flux.interval(Duration.ofMillis(1000)).publish().autoConnect();
		source.subscribe();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		source.toStream().forEach(System.out::println);//5 6 7 8 9 第二个订阅者只能获取到5以后的元素
//
//	}
//
//
//	/**
//	 * 同步转异步
//	 * 之前Excutors可以实现，现在这个更简洁
//	 * @throws InterruptedException
//	 */
//	public static void testSyncToAsync() throws InterruptedException {
//		CountDownLatch latch = new CountDownLatch(1);
//		Mono.fromCallable(() -> getStringSync())
//			.subscribeOn(Schedulers.elastic())
//			.subscribe(System.out::println, null, latch::countDown);
//		latch.await(10, TimeUnit.SECONDS);
//	}
//
//	private static String getStringSync() {
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return "Hello, Reactor!";
	}

}
