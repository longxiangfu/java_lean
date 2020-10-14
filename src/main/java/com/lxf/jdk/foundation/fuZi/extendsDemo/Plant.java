package com.lxf.jdk.foundation.fuZi.extendsDemo;

public class Plant {
    protected static Double height = 3.21;//proteted作用域使子类可以继承该属性
    protected Double weight = 1.03;
    protected static String color = "blue";

    protected static void grow(){
        System.out.println("父类的grow方法");
    }

    protected static void grow1(){
        System.out.println("父类的grow1方法");
    }
}
