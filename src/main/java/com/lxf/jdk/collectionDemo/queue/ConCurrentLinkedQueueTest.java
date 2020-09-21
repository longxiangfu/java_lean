package com.lxf.jdk.collectionDemo.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ConCurrentLinkedQueue：非阻塞队列，线程安全（CAS）
 */
public class ConCurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
        concurrentLinkedDeque.add("A");
        concurrentLinkedDeque.add("A");
        concurrentLinkedDeque.add("A");
//        concurrentLinkedDeque.add(null);//空指针异常
        if (!concurrentLinkedDeque.isEmpty()) {
            System.out.println(concurrentLinkedDeque.poll());
        }
    }
}
