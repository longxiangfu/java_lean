package com.lxf.jdk8.concurrent.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo3 {
    public static void main(String[] args) throws InterruptedException {
        final MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
        Thread r1 = new Thread(() ->{
            myReadWriteLock.read();
        }, "r1");
        Thread r2 = new Thread(() ->{
            myReadWriteLock.read();
        }, "r2");
        r1.start();
        r2.start();
        r1.join();
        r2.join();

        new Thread(() ->{
            myReadWriteLock.write();
        }, "w1").start();
        new Thread(() ->{
            myReadWriteLock.write();
        }, "w2").start();

//        读取进入|线程r1
//        读取进入|线程r2
//        读取退出|线程r2
//        读取退出|线程r1
//        写入进入|线程w1
//        写入退出|线程w1
//        写入进入|线程w2
//        写入退出|线程w2

    }


    private static class MyReadWriteLock{
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read(){
            try{
                //加读锁
                lock.readLock().lock();
                System.out.println("读取进入|线程" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("读取退出|线程" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }

        public void write(){
            try {
                //加写锁
                lock.writeLock().lock();
                System.out.println("写入进入|线程" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("写入退出|线程" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }

    }
}
