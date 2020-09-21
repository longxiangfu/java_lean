package com.lxf.jdk.collectionDemo.compare;

import java.util.Arrays;

/**
 * 外部比较器
 * 比较：
 * 1、内部比较器：需要在类的内部实现Comparable接口，并重写compateTo()方法
 *    外部比较器：在外部单独写比较器，该比较器实现Compatator接口，并重写compare()方法
 * 2、外部比较器更加灵活
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{
                new Dog("beibei", 10),
                new Dog("heide", 13),
                new Dog("erduo", 7)
        };
//        Arrays.sort(dogs, new Comparator<Dog>() {
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                return o1.getAge() -o2.getAge();
//            }
//        });
        Arrays.sort(dogs, (o1, o2) -> o1.getAge() - o2.getAge());
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(String.format("名字：%s，年龄：%d", dogs[i].getName(), dogs[i].getAge()));
        }
    }
}
