package com.lxf.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.WorkQueueProcessor;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Scheduler.Worker;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * 利用reactor实现多生产者-多消费者，无需加锁
 * @author longxiangfu
 *
 */
public class ReactorSample {
	private static final AtomicLongFieldUpdater<ReactorSample> SUM = AtomicLongFieldUpdater.newUpdater(ReactorSample.class, "sum");
	private volatile long sum = 0;
	private FluxSink<String> sink = null;
	
	private void startServer() {
		WorkQueueProcessor<String> flux = WorkQueueProcessor.share("test", 4096);
		int processors = Runtime.getRuntime().availableProcessors();//获取当前机器的cpu核数
		
		for (int i = 0; i < processors; i++) {
			flux.subscribe(e -> {
				for (long l = 0; l < 1000; l++) {
					e.substring(0, 1);
				}
				SUM.accumulateAndGet(this, 1, (l, r) -> l + r);
			});
		}
		
		Queue<Worker> workers = new ArrayBlockingQueue<>(processors);
		
		Scheduler scheduler = Schedulers.elastic();
		for (int i = 0; i < processors; i++) {
			workers.offer(scheduler.createWorker());
		}
			
		this.sink = flux.sink();
		sink.onRequest(l -> {
			final Worker worker = workers.poll();
//			if (worker != null) {
			worker.schedule(() -> {
				try {
//				System.out.println(Thread.currentThread().getName() + "-" + l);
					for (int j = 0 ; j < l ; j++) {
						sink.next(Thread.currentThread().getName() + "-" + j);
					}
				} finally {
					workers.offer(worker);
				}
			});
		});
		
		long time = System.currentTimeMillis();
		scheduler.createWorker().schedule(() -> {
			Flux.interval(Duration.ofSeconds(1)).subscribe(e -> {
				System.out.println(SUM.get(this) / ((System.currentTimeMillis() - time) / 1000));
			});
		});
	}
	
	public static void main(String[] args) {
		new ReactorSample().startServer();
	}
}
