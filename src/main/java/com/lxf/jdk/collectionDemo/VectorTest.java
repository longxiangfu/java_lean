package com.lxf.jdk.collectionDemo;

import java.util.Vector;

/**
 * 1、线程安全
 * 2、底层是数组
 * 3、默认容量10，按2倍扩容
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
    }
}
