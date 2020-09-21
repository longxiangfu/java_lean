package com.lxf.jdk.collectionDemo.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列:LinkedList实现了Deque
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("A");
        deque.add("B");
        deque.add("C");
        if (!deque.isEmpty()) {
            System.out.println(deque.peek());
        }
    }

}
