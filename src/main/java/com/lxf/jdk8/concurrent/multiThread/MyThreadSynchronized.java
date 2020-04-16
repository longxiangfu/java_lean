package com.lxf.jdk8.concurrent.multiThread;

/**
 * Synchronized修饰代码块、普通方法、静态方法
 * 锁对象分别是：括号里的对象、类的实例、类的Class对象
 */
public class MyThreadSynchronized implements Runnable{

	@Override
	public void run() {
		synchronized (this){
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
		
	}

	public synchronized void lock(){

	}

	public static synchronized void staticLock(){

	}

}
