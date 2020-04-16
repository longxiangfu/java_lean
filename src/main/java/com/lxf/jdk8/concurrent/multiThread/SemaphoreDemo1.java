package com.lxf.jdk8.concurrent.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Semaphore信号量:控制访问资源的线程个数
 * @author longxiangfu
 *
 */
public class SemaphoreDemo1 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);//总共有3个许可
		for(int i = 0;i < 10;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Runnable runnabele = new Runnable() {
				@Override
				public void run() {
					try {
						sp.acquire();//获取许可
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程"+Thread.currentThread().getName()+
							"进入，当前已有"+(3-sp.availablePermits())+"并发");
					try {
						Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
					sp.release();//释放许可
					
				}
				
			};
			service.execute(runnabele);
		}
	}

}
