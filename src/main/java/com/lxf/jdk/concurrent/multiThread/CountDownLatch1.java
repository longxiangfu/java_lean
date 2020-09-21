package com.lxf.jdk.concurrent.multiThread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示1:CountDownLatch（将军和士兵）
 * @author longxiangfu
 *
 */
public class CountDownLatch1 {
	private static Random random = new Random(System.currentTimeMillis());
	private static ExecutorService executor = Executors.newFixedThreadPool(2);
	private static CountDownLatch latch = new CountDownLatch(9);
	
	public static void main(String[] args) throws InterruptedException {
		int[] data = query();
		for(int i = 0, len = data.length; i< len; i++ ) {
			executor.execute(new SimpleRunnAble(data, i, latch));
		}
		latch.await();//保证所有子线程执行完毕，主线程再执行下面的程序（等待CountDownLatch计数为0）
		executor.shutdown();
		System.out.println("取到数字:"+ Arrays.toString(data));
	}
	
	
	static class SimpleRunnAble implements Runnable{
		private final int[] data;
		private final int index;
		private final CountDownLatch latch;
		
		SimpleRunnAble(int[] data, int index, CountDownLatch latch){
			this.data = data;
			this.index = index;
			this.latch = latch;
		}
		
		@Override
		public void run() {
			try{
				Thread.sleep(random.nextInt(1000));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			int value = data[index];
			if(value % 2 == 0) {
				data[index] = value * 2;
			}else {
				data[index] = value * 1;
			}
			System.out.println(Thread.currentThread().getName()+"结束！");
			latch.countDown();//计数器-1
		}
	}
	
	private static int[] query() {
		return new int[]{1,2,3,4,5,6,7,8,9};
	}

	

}
