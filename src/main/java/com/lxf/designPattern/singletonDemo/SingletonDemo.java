package com.lxf.designPattern.singletonDemo;
/**
 * java设计模式-单例模式
 * @author longxiangfu
 *
 */
public class SingletonDemo {
	/*
	 * 饿汉式：类加载时，将类实例属性加载到方法区
	 * 1、线程安全
	 * 2、使用内存高
	 */
//	//私有构造方法
//	private SingletonDemo() {};
//	//私有static final 类实例属性
//	private static final SingletonDemo instance = new SingletonDemo();
//	
//	//静态方法返回类实例
//	public static SingletonDemo getInstance() {
//		return instance;
//	}
	
	
	/*
	 *一、饱汉式：在静态方法中返回类实例
	 *1、线程不安全
	 *2、使用内存低
	 */
//	//私有构造方法
//	private SingletonDemo() {};
//	//私有static类属性
//	private static SingletonDemo instance;
//	
//	//静态方法返回类实例（多线程时，可以实例化多次）
//	public static SingletonDemo getInstance() {
//		if(null == instance) {
//			instance = new SingletonDemo();
//		}
//		return instance;
//	}
	/*
	 * 二、饱汉式
	 */
//	private SingletonDemo() {};
//	private static SingletonDemo instance;
//	
//	//保证了线程安全，但是高并发时效率低
//	public static synchronized SingletonDemo getInstance() {
//		if(null == instance) {
//			instance = new SingletonDemo();
//		}
//		return instance;
//	}
	
	
	/*
	 * 三、饱汉式
	 * 1、线程安全
	 * 2、使用内存低
	 */
	//私有构造方法
	private SingletonDemo() {};
	//私有static volatitle类属性（保证SingletonDemo实例的线程可见性）
	private static volatile SingletonDemo instance;
	
	public static SingletonDemo getInstance() {
		if(null == instance) {
			synchronized (SingletonDemo.class) {//同步代码块，线程安全
				instance = new SingletonDemo();
			}
		}
		return instance;
	}
	

}
