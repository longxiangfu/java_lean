package com.lxf.jdk8.concurrent.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore：也可实现互斥锁，同ReenterantLock
 * @author longxiangfu
 *
 */
public class SemaphoreDemo2 {
	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i = 0;i < 3;i++) {
			executor.execute(
					new Runnable() {
						public void run() {
							bussiness.service();
						}
					}
					);
		}
		executor.shutdown();
	}
	
	private static class Bussiness {
		private int count;
//		Lock lock = new ReentrantLock();
		Semaphore sp = new Semaphore(1);
		
		public void service() {
//			lock.lock();
			try {
				sp.acquire();//当线程使用count变量的时候将count锁住，不允许其他线程访问
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			try {
				count++;
				Thread.sleep(1000);
				System.out.println(count);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sp.release();//释放锁
//				lock.unlock();
			}
			
		}
	}

}
