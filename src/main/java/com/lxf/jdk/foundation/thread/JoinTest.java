package com.lxf.jdk.foundation.thread;

/**
 * 保证一线程执行完才执行当前线程
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread joinThread = new Thread(() ->{
            try {
                System.out.println("执行前");
                Thread.sleep(1000);
                System.out.println("执行后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        joinThread.start();
        joinThread.join();
        System.out.println("主程序");
//        执行前
//        执行后
//        主程序
    }
}
