package com.lxf.jdk8.concurrent.cas;

import java.util.concurrent.atomic.LongAdder;

/**
 * 原子操作，效率比AtomicLong等都要高
 */
public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(10);
        System.out.println(longAdder.longValue());
    }
}
