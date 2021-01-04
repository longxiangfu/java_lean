package com.lxf.jdk.concurrent.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示Condition  同Synchronized的wait/notify
 */
public class MyThreadReentrantLock1 {
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();//Condition相当于Synchronized中锁对象

    public static void main(String[] args)  {
        MyThreadReentrantLock1 useCase = new MyThreadReentrantLock1();
        ExecutorService executorService = Executors.newFixedThreadPool (2);
        executorService.execute(() -> useCase.conditionWait());
        executorService.execute(() -> useCase.conditionSignal());
    }

    public void conditionWait()  {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到锁了");
            System.out.println(Thread.currentThread().getName() + "等待信号");
            //释放锁
            condition.await();//相当于锁锁对象的方法wait
            System.out.println(Thread.currentThread().getName() + "拿到信号");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void conditionSignal() {
        lock.lock();
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "拿到锁了");
            condition.signal();//相当于锁对象的notify/notifyAll
            System.out.println(Thread.currentThread().getName() + "发出信号");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
