package com.lxf.jdk.foundation.fuZi;

/**
 * 类的实例化顺序
 * 先静态再父子
 * 父类静态数据>子类静态数据>父类字段>父类构造>子类字段>子类构造
 */
public class Test {
    public static void main(String[] args) {
        //测试类的实例化顺序
        Dog dog = new Dog();
    }
}
