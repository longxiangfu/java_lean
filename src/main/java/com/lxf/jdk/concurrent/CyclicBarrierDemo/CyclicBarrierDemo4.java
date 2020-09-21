package com.lxf.jdk.concurrent.CyclicBarrierDemo;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier:屏障。当所有线程到达屏障时，才触发一个动作
 * 1、await():表示线程到达了屏障
 * 2、例子：客车坐满，就发车
 */
public class CyclicBarrierDemo4 {
    public static void main(String[] args) throws InterruptedException {
        //定义CyclicBarrier,包含4个线程，一个触发动作
        CyclicBarrier barrier = new CyclicBarrier(4, () ->{
            System.out.println("发车了");
        });
        for (int i = 0; i < 14; i++) {
            if (i % 4 ==0) {
                TimeUnit.SECONDS.sleep(2);
            }
            new Thread(new MyRunnable(barrier)).start();
        }
    }

    private static class MyRunnable implements Runnable{
        private CyclicBarrier barrier;
        public MyRunnable(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("乘客：" + Thread.currentThread().getName());
            barrier.await();//表示当前线程到达了屏障
//            barrier.await();//重复调用await(),“发车了”会增加一倍
        }
    }

//    乘客：Thread-0
//    乘客：Thread-1
//    乘客：Thread-2
//    乘客：Thread-3
//    发车了
//    乘客：Thread-4
//    乘客：Thread-5
//    乘客：Thread-6
//    乘客：Thread-7
//    发车了
//    乘客：Thread-8
//    乘客：Thread-9
//    乘客：Thread-10
//    乘客：Thread-11
//    发车了
//    乘客：Thread-12
//    乘客：Thread-13

}
