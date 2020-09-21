package com.lxf.jdk.foundation.thread;

/**
 * Thread.interrupt():线程中断，会立刻中断，相当于java关键字break
 * System.exit(0):让整个程序中断
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread interruptThread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if(i == 10){
                    currentThread.interrupt();
//                    System.exit(0);
                }
                System.out.println(i);
                if(currentThread.isInterrupted()){
                    System.out.println("我中断了");
                    break;
                }
            }
        });
        interruptThread.start();

    }
}
