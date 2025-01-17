package com.lxf.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 模拟CAS操作（本示例未演示多线程操作的原子性，但是原子操作类能够保证原子操作）
 * @author longxiangfu
 *
 */
public class Cas {
	private AtomicBoolean locked = new AtomicBoolean(false);
	
	public boolean lock() {
		return locked.compareAndSet(false, true);
	}
	
	public static void main(String[] args) {
		Cas cas = new Cas();
		System.out.println(cas.lock());	
	}

}
