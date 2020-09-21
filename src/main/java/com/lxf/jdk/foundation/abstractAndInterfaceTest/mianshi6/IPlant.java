package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi6;

/**
 * 函数式接口
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface IPlant<F, T> {
    //有@FunctionalInterface注解的接口，有并且只有一个抽象方法
    T sleep(F from);//抽象方法不能是private static final    可以是public 默认

    default void printAge(){
        System.out.println("18");
    }

    static void printName(){
        System.out.println("dog");
    }

    String name = "beibei";
    static String age = "10";

}
