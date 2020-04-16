package com.lxf.jdk8.foundation.thread;

/**
 * 死锁
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Object lock = new Object();
        Object lock1 = new Object();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + " 已经获取锁lock");
           synchronized (lock){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + " 将要获取锁lock1");
               synchronized (lock1){
                   System.out.println(Thread.currentThread().getName() + " 已经获取锁lock1");
               }
           }
        }).start();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + " 已经获取锁lock1");
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 将要获取锁lock");
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + " 已经获取锁lock");
                }
            }
        }).start();

//        Thread-0 已经获取锁lock
//        Thread-1 已经获取锁lock1
//        Thread-1 将要获取锁lock
//        Thread-0 将要获取锁lock1

    }
}
