package com.lxf.jdk.concurrent.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁相比synchonized:
 * 1、等待可中断：tryLock(long time, TimeUnit unit)、lockInterruptibly()
 * 2、可以创建公平锁（他们默认创建的都是非公平锁，不过非公平锁效率高）:构造函数boolean设置为true,ReentrantLock(boolean fair)
 * @author 15652
 *
 */
public class MyThreadReentrantLock implements Runnable{
	
	private ReentrantLock lock = new ReentrantLock();
//	private ReentrantLock lock1 = new ReentrantLock(true);//公平锁
	@Override
	public void run() {
		lock.lock();
		lock.tryLock();
		try {
			lock.tryLock(3, TimeUnit.SECONDS);//获取锁期间，若线被中断，则抛出InterruptedException
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			lock.lockInterruptibly();//获取锁期间，若线程被中断，则抛出InterruptefException
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			for(int i = 0;i < 5;i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}finally {
			//解锁
			lock.unlock();
		}
		
	}
	

}
