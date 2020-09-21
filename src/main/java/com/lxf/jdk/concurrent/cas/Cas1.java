package com.lxf.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class Cas1 {
	AtomicInteger atomicInteger = new AtomicInteger(10);
	
	public boolean lock() {
		return atomicInteger.compareAndSet(10, 100);
	}

	public static void main(String[] args) {
		

	}

}
