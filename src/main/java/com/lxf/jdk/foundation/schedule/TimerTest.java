package com.lxf.jdk.foundation.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    // 静态竖向，jvm在加载TimerTest时就加载了静态属性，在jvm中只有一份
    private static final Timer TIMER = new Timer();

    public static void main(String[] args) {
        delaySchedule();
    }

    /**
     * 延时定时任务
     * 相比线程池的定时任务（固定频率执行），这里能控制任务执行的时间间隔
     */
    private static void delaySchedule() {
        TIMER.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); // 模拟执行任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行完了");
                delaySchedule();
            }
        }, 2000);
    }
}
