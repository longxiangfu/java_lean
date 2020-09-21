package com.lxf.jdk.concurrent.multiThread;

import java.util.concurrent.*;

/**
 * 因为每次循序先执行release()，相当于加了一个信号量
 */
public class SemaphoreDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        CountDownLatch latch = new CountDownLatch(3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 3; i++) {
            executor.execute(() ->{
                semaphore.release();
                System.out.println("可用信号量：" + semaphore.availablePermits());
                try {
                    Thread.sleep(1000);
                    semaphore.acquire();
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        可用信号量：3
//        可用信号量：4
//        可用信号量：5
    }
}
