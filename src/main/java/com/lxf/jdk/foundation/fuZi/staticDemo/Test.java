package com.lxf.jdk.foundation.fuZi.staticDemo;

/**
 * 先静态再父子
 * 先静态代码块后普通代码块
 */
public class Test {
    public static void main(String[] args) {
        B b1 = new B();
        System.out.println("====");
        B b2 = new B();
    }
//    A1:父类静态代码区域
//    B1:子类静态代码区域
//    A2：父类非静态代码区域
//    A3：父类构造器
//    B2：子类非静态代码区域
//    B3：子类构造器
//    ====
//    A2：父类非静态代码区域
//    A3：父类构造器
//    B2：子类非静态代码区域
//    B3：子类构造器
}
