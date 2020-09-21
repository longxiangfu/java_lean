package com.lxf.jdk.concurrent.CyclicBarrierDemo;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo3 {
	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {		
            @Override
            public void run() {
                try {
                    c.await();   
                } catch (Exception e) {
                }
                System.out.println(c.getNumberWaiting());//阻塞的线程数量
            }
        });
        thread.start();
        thread.interrupt();

        try {
            c.await();  
        } catch (Exception e) {
            System.out.println(c.isBroken());//线程是否有中断
        }
        System.out.println(c.getNumberWaiting());
        try {
        	throw new Exception("我抛出一个 错误！");
        }catch(Exception e) {
        	e.printStackTrace();
        	c.reset();//发生异常时，可重置（CountDownLatch不能重置）
        	System.out.println(c.getParties());
        }

	}

}
