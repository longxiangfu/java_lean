package com.lxf.jdk8.foundation.thread;

/**
 * Thread.yield():当前线程让出cpu执行权，让同优先级别的线程有机会执行。
 * 但并不能立即由运行状态(Runnable)变为可运行状态(Runnable):结果会持续输出
 * 变成可运行状态后，若再次获取到执行权限时，会再次进入运行状态
 */
public class YieldTest {
    public static void main(String[] args) throws InterruptedException {
        Thread yieldThread = new Thread(() ->{
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (i == 10){
                    Thread.yield();
                }
                System.out.println(i);

            }
        });
        yieldThread.setPriority(10);//设置线程优先级
        yieldThread.start();

    }
}
