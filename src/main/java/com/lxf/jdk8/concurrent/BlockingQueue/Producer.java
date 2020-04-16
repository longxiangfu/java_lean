package com.lxf.jdk8.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	protected BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Produced resource - Queue size now = "
                        + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer INTERRUPTED");
        }
    }

    Object getResource() {
        try {
            Thread.sleep(100); //模拟生产者准备消息时间
        } catch (InterruptedException ex) {
            System.out.println("Producer Read INTERRUPTED");
        }
        return new Object();
    }

}
