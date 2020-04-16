package com.lxf.jdk8.concurrent.multiThread;

/**
 * 演示synchronezized和ReentrantLock(可重入锁)
 * @author longxiangfu
 *
 */
public class ReentrantLockDemo {
	public static void main(String[] args) {
//		Runnable t1 = new MyThreadSynchronized();
		Runnable t1 = new MyThreadReentrantLock();
		new Thread(t1, "t1").start();
		new Thread(t1, "t2").start();
	}
	

}
