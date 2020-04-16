package com.lxf.jdk8.concurrent.CyclicBarrierDemo;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier.CyclicBarrier(int parties, Runnable barrierAction)
 * 当所有线程到达屏障时，优先执行barrierAction任务
 *输出3 1 2 或3 2 1
 * @author longxiangfu
 *
 */
public class CyclicBarrierDemo2 {
	static CyclicBarrier c = new CyclicBarrier(2, new A());

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					c.await();
				}catch(Exception e) {
					//
				}
				System.out.println(1);	
			}
		}).start();
		
		try {
			c.await();
		}catch(Exception e) {
			//
		}
		System.out.println(2);

	}

}

class A implements Runnable{

	@Override
	public void run() {
		System.out.println(3);
		
	}
}
