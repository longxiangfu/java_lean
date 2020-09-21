package com.lxf.jdk.foundation.thread;

/**
 * 1、Object.wait(),Object.notify(),Object.notifyAll()使用时，必须先获取对象锁，否则会抛出IllegalMonitorStateException
 * 2、调用wait()后，当前线程会释放对象锁，当前线程进入对象的等待池中，直到别的线程调用对象的notify或notifyAll,当前线程进入
 *    对象的锁池中，去竞争对象锁，如果没有竞争到锁，那么线程一直留在锁池中，直到该线程调用wait后重新进入对象等待池中
 * 3、notify：随机唤醒对象等待池中一个线程；notifyAll:唤醒对象等待池中所有线程
 * 4、线程的6种状态
 */
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        //wait使用
//        System.out.println(LocalDateTime.now());
//        Object lock = new Object();
//        Thread thread = new Thread(() -> {
//            synchronized (lock){
//                try {
////                    lock.wait(1000);//1秒后自动唤醒
//                    lock.wait();//需要notify或notifyAll进行唤醒
//                    System.out.println(LocalDateTime.now());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();


        //notify\notifyAll结合wait使用
        Object lock = new Object();
        Thread downLoadThread = new Thread(() ->{
            System.out.println("下载图片开始");
            for (int i = 0; i < 101; i+=10) {
                System.out.println("%" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock){
                lock.notifyAll();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread showThread = new Thread(() ->{
            System.out.println("等待图片下载完毕");
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始展示图片");
                System.out.println("展示图图片");
            }
        });

        downLoadThread.start();
        showThread.start();
//                下载图片开始
//                等待图片下载完毕
//                %0
//                %10
//                %20
//                %30
//                %40
//                %50
//                %60
//                %70
//                %80
//                %90
//                %100
//                开始展示图片
//                展示图图片

    }
}
