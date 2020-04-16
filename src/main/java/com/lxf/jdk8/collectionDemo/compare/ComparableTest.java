package com.lxf.jdk8.collectionDemo.compare;

import java.util.Arrays;

/**
 * 内部比较器
 */
public class ComparableTest {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{
                new Dog("beibei", 10),
                new Dog("heide", 13),
                new Dog("erduo", 7)
        };
        Arrays.sort(dogs);
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(String.format("名字：%s，年龄：%d", dogs[i].getName(), dogs[i].getAge()));
        }
    }
}
