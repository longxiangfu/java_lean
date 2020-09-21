package com.lxf.jdk.collectionDemo.compare;

public class Test {
    public static void main(String[] args) {
        //Integer实现了Comparable接口，重写了compareTo方法,定义了自然排序规则
        Integer num = 10;
        Integer num1 = 5;
        System.out.println(num.compareTo(num1));
    }
}
