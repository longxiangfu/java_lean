package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianShi1;

/**
 * 在java中，变量不能被重写，方法才能被重写
 */
public class B extends A {
    public int x = 1;
    public static int y = 2;
    public void m() {
        System.out.print("B");
    }

    public static void main(String[] args) {
        A myClass = new B();
        //在java中，变量不能被重写
        System.out.print(myClass.x);//0
        System.out.print(myClass.y);//0
        //myClass是A类型引用，先调用A的m(),发现被重写了，于是调用重写的方法
        myClass.m();//B

        B bClass = new B();
        int x = bClass.x;
        int y = bClass.y;
    }
}
