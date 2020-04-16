package com.lxf.disruptor.ringbuffer;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多生产者-多消费者
 * 使用RingBuffer
 * 一个Event只能被某一个消费者处理
 * @author longxiangfu
 * 
 */
public class demo {
	public static void main(String[] args) {
		//创建RingBuffer
        RingBuffer<Order> ringBuffer = 
                RingBuffer.create(ProducerType.MULTI, 
                        new EventFactory<Order>() {  
                            @Override  
                            public Order newInstance() {  
                                return new Order();  
                            }  
                        }, 
                        1024 * 1024, new YieldingWaitStrategy());
        
        SequenceBarrier barriers = ringBuffer.newBarrier();
        
        Consumer[] consumers = new Consumer[3];
        for(int i = 0; i < consumers.length; i++){
            consumers[i] = new Consumer("ct" + i);
        }
        // 3个消费者
        WorkerPool<Order> workerPool = new WorkerPool<Order>(ringBuffer, barriers, new MyExceptionHandler(), consumers);
        
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());  
        ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        workerPool.start(executors);  
        // 10个生产者, 每个生成者生产20个数据
        for (int i = 0; i < 10; i++) {  
            final Producer p = new Producer(ringBuffer);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 2; j++){
                        p.produceData(UUID.randomUUID().toString());
                    }
                }
            }).start();
        } 
        
        System.out.println("----开始生产----");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  // 等待消费完成
        System.out.println("总共消费数量:" + consumers[0].getCount() );
        
        workerPool.halt(); 
        executors.shutdown();
	}
}
	

