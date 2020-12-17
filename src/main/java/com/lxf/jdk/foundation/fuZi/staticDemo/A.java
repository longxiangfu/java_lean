package com.lxf.jdk.foundation.fuZi.staticDemo;

public class A {
    static {
        System.out.println("A1:父类静态代码区域");
    }



    {
        System.out.println("A2：父类非静态代码区域");
    }

    public A() {
        System.out.println("A3：父类构造器");
    }
}
