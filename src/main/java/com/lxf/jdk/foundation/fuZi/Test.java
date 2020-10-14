package com.lxf.jdk.foundation.fuZi;

/**
 * 类的实例化顺序
 * 先静态再父子
 * 父类静态数据>子类静态数据>父类字段>父类无参构造>子类字段>子类构造（无参构造和有参构造）
 * 子类实例化方式无论是无参构造还是有参构造，都会默认调用父类的无参构造
 *
 * 构造函数是无法继承的
 */
public class Test {
    public static void main(String[] args) {
        //测试类的实例化顺序
//        Dog dog = new Dog();

        Dog dog1 = new Dog("beibei");
    }
}
