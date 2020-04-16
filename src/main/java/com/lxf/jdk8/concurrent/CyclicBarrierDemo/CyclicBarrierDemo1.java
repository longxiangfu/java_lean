package com.lxf.jdk8.concurrent.CyclicBarrierDemo;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 屏障
 * 多辆汽车过收费站的模型；银行流水场景
 *输出1 2 或2 1
 * @author longxiangfu
 *
 */
public class CyclicBarrierDemo1 {
	static CyclicBarrier c = new CyclicBarrier(2);

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
