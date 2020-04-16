package com.lxf.jdk8.collectionDemo.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue
 * 1、在初始化时必须指定容量，且容量不可修改
 * 2、存在公平访问和非公平访问
 * 3、访问线程安全（ReenterLock）
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(6);
        ArrayBlockingQueue<Integer> arrayBlockingQueue1 = new ArrayBlockingQueue<>(6, true);
        arrayBlockingQueue1.add(null);//会报空指针异常
    }
}
