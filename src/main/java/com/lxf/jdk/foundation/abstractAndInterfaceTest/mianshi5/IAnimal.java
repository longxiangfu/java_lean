package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi5;

public interface IAnimal {
    default void printAge(){
        System.out.println("18");
    }
    default void printAge1(){
        System.out.println("20");
    }

    static void printName(){
        System.out.println("dog");
    }
    static void printName1(){
        System.out.println("cat");
    }

    String name = "beibei";
    static String age = "10";
    String name1 = "";


    void eat();

    void hug();
}
