package com.lxf.jdk.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger：两个线程间进行数据交换
 */
public class ExchangeTest {
    private static Logger logger = LoggerFactory.getLogger(ExchangeTest.class);
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    //创建一个Exchange
    private static Exchanger<String> change = new Exchanger<>();

    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String a = "change data--1";
                try {
                    String b = change.exchange(a);
                    logger.info("current thread:" + Thread.currentThread().getName() + "  before change:" + a + " after change:" + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String b = "change data--2";
                try {
                    String a = change.exchange(b);
                    logger.info("current thread:" + Thread.currentThread().getName() + "  before change:" + b + " after change:" + a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
