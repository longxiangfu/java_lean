//package com.lxf.redis;
//
//import org.redisson.Redisson;
//import org.redisson.api.RPermitExpirableSemaphore;
//import org.redisson.api.RSemaphore;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * 1.可重入锁  Reentrant Lock  :分布式锁
// * 2.公平锁 Fair Lock  :锁优先分配给先发出请求的线程
// * 3.联锁  MultiLock   ：所有的锁锁成功,才算成功上锁
// * 4.红锁  RedLock  ：在大部分节点上加锁成功就算成功
// * 5.读写锁  RReadWriteLock：同java中的重入读写锁
// */
//public class RedissonLockTest {
//    @Autowired
//    static Redisson redisson;
//
//    public static void main(String[] args) throws InterruptedException {
//        //6.信号量  Semaphore
//        RSemaphore semaphore = redisson.getSemaphore("semaphore");
//        semaphore.acquire();//获取一个许可
//        semaphore.acquire(10);//获取10个许可
//        semaphore.release();//释放一个许可
//        semaphore.release(10);//释放10个许可
//
//        //7.可过期性信号量  PermitExpirableSemaphore
//        RPermitExpirableSemaphore semaphore1 = redisson.getPermitExpirableSemaphore("mySemaphore");
//        semaphore1.acquire(2, TimeUnit.SECONDS);//获取一个信号，有效期2秒
//
//        //8.闭锁  CountDownLatch   同java中的计数器
//
//    }
//}