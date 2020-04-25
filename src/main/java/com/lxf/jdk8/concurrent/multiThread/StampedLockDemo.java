package com.lxf.jdk8.concurrent.multiThread;

import java.util.concurrent.locks.StampedLock;

/**
 * 演示StampedLock
 * 1、写锁：和ReentrantReadWriteLock的写锁
 * 2、悲观读：和ReentrantReadWriteLock的写锁
 * 3、乐观读：上乐观锁期间，允许其他线程写入
 */
public class StampedLockDemo {
    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();
//        beiGuanReadLockTest(stampedLock);
//        optimisticReadLockTest(stampedLock);
//        writeLockTest(stampedLock);

        new Thread(() ->{
            optimisticReadLockTest(stampedLock);
        }).start();
        new Thread(() ->{
            writeLockTest(stampedLock);
        }).start();

    }

    private static void optimisticReadLockTest(StampedLock stampedLock) {
        //获取乐观锁
        long stamp = stampedLock.tryOptimisticRead();
        System.out.println("乐观读锁stamp:" + stamp);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!stampedLock.validate(stamp)) {//判断是否有写锁进行数据修改
            //有3种处理方法
            //1、重复获取乐观锁
            //2、直接上悲观读锁
            //3、两者结合
        }
    }

    private static void beiGuanReadLockTest(StampedLock stampedLock) {
        long stamp = stampedLock.readLock();
        try {
            //业务操作
        }finally {
            stampedLock.unlockRead(stamp);
        }
    }

    private static void writeLockTest(StampedLock stampedLock) {
        long stamp = stampedLock.writeLock();
        System.out.println("写锁stamp:" + stamp);
        try {
            //业务操作
        }finally {
            stampedLock.unlockWrite(stamp);
        }

    }

}
