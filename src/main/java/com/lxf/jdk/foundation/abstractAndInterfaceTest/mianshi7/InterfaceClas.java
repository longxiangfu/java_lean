package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi7;

/**
 * 演示接口和抽象类的方法类别、是否静态、访问修饰
 */
public interface InterfaceClas {
    /**
     * 接口有default static 抽象方法
     */
    default void test1(){}
    static void test2(){}
    void test3();

    /**
     * default可以是public和默认的
     */
    default void test4(){}

    /**
     * 静态方法可以是public和默认的
     */
    static void test5(){}

    /**
     * 抽象方法可以是public和默认的
     */
    void test6();
}
