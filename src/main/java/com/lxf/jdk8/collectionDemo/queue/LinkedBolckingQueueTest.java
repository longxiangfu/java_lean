package com.lxf.jdk8.collectionDemo.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBolckingQueue
 * 1、并发包下，访问线程安全（ReenterLock）
 * 2、可以不用指定容量，默认容量是Integer.MAX_VALUE
 */
public class LinkedBolckingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.add("A");
        linkedBlockingQueue.add("B");
//        linkedBlockingQueue.add(null);//会报空指针异常
        if (!linkedBlockingQueue.isEmpty()) {
            System.out.println(linkedBlockingQueue.peek());
        }

    }

}
