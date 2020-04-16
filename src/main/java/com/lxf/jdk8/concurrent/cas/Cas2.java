package com.lxf.jdk8.concurrent.cas;

import com.lxf.jdk8.Person;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description CAS
 * @Author Administrator
 * @DATE 2019/4/15 14:32
 * @Version 1.0
 **/
public class Cas2 {
    public static void main(String[] args) {
        //AtomicBollean AtomicInteger AtomicLong AtomicReference

        //1、cas操作，系统cpu保证操作的原子性，原子操作对应系统的一条指令
        AtomicInteger count = new AtomicInteger(0);
        count.incrementAndGet();
        count.compareAndSet(10, 100);
        AtomicReference<Person> reference = new AtomicReference<>();

        //2、cas造成ABA问题：一个线程把值+1，然后再-1，对另一个线程而言，值不变，这可能带来问题
        // 解决：使用AtomicStampedReference进行版本控制
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference<>(100, 1);
        System.out.println("reference:" + atomicStampedReference.getReference());
        System.out.println("stamp:" + atomicStampedReference.getStamp());
        atomicStampedReference.compareAndSet(atomicStampedReference.getReference(), 200,
                atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
        System.out.println("reference:" + atomicStampedReference.getReference());
        System.out.println("stamp:" + atomicStampedReference.getStamp());



    }
}
