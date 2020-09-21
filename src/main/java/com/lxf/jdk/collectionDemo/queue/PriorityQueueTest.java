package com.lxf.jdk.collectionDemo.queue;

import java.util.PriorityQueue;

/**
 * 优先级队列：可以自定义比较器；不允许null值
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(((o1, o2) -> {
            //倒序
            return (Integer) o2 - (Integer) o1;
        }));
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(10);
        priorityQueue.add(4);
//        priorityQueue.add(null);//或抛空指针

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }

}