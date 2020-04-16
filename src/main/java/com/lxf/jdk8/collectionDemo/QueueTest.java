package com.lxf.jdk8.collectionDemo;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new ArrayBlockingQueue(64);
        queue.poll();//没有值时，返回null
        queue.remove();//没有值时，抛异常
    }
}
