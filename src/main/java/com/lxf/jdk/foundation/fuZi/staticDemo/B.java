package com.lxf.jdk.foundation.fuZi.staticDemo;

public class B extends A {
    static {
        System.out.println("B1:子类静态代码区域");
    }


    {
        System.out.println("B2：子类非静态代码区域");
    }

    public B() {
        System.out.println("B3：子类构造器");
    }
}
