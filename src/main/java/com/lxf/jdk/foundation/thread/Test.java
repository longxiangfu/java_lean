package com.lxf.jdk.foundation.thread;

public class Test {
    public static void main(String[] args) {
        //new Thread()，使用Lamda表达式
        new Thread(() -> System.out.println("new Thread"));

        //让两个程序依次输出11/22/33
        new Thread(() ->{
            Thread currentThread = Thread.currentThread();
            for (int i = 1; i < 4; i++) {
                System.out.println(currentThread.getName()+ ":" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() ->{
            Thread currentThread = Thread.currentThread();
            for (int i = 1; i < 4; i++) {
                System.out.println(currentThread.getName()+ ":" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
