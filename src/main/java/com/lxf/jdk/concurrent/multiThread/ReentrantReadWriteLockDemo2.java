package com.lxf.jdk.concurrent.multiThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁模拟一个缓存器
 * @author longxiangfu
 *
 */
public class ReentrantReadWriteLockDemo2 {
	private static Map<String, Object> map = new HashMap<String, Object>();//缓存器
	private static ReadWriteLock rw = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		Object value = null;
		rw.readLock().lock();//上读锁，从缓存中取
		try {
			value = map.get("a");
			if(null == value) {//如果缓存中没有值，则释放读锁，上写锁
				rw.readLock().unlock();
				rw.writeLock().lock();
				try {
					if(null == value) {
						value = "aaa";
					}
				}finally {
					/*
					 * 释放写锁之前，上读锁（锁允许降级，不允许升级，即writeLock允许降级为readLock，反之则不行）
					 */
					rw.readLock().lock();
					rw.writeLock().unlock();
					
				}
			}
		}finally{
			rw.readLock().unlock();//释放读锁
		}
		
		System.out.println(value);
	}

}
