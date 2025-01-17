package com.lxf.jdk.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList:修改List时候，复制该集合的副本，对副本进行操作，最后将修改后的集合赋值给原先的集合
 * 修改的时候，add（）和set（）方法中有锁，所以同一时间只能有一个线程进行add;此时别的线程不能修改，但是可以读取
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);

        copyOnWriteArrayList.set(0, 10);

        copyOnWriteArrayList.get(1);

        int a = 10;
        new Thread(() -> {
            System.out.println(a);
        });
    }
}
