package com.lxf.jdk8.concurrent.multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 演示2:CountDownLatch
 * @author longxiangfu
 *
 */
public class CountDownLatch2 {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);//1秒
					latch.countDown();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		/**
         * 最多等待10秒
         * 1.如果10秒内，没有countDown为0，10秒后放行
         * 2.如果10秒内，countDown为0，立刻放行，不用等待10秒
         */
		latch.await(10, TimeUnit.SECONDS);//10秒
		System.out.println("======");
	}
	
}
