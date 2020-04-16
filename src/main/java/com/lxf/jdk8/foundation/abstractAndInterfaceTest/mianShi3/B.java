package com.lxf.jdk8.foundation.abstractAndInterfaceTest.mianShi3;

/**
 * 父类静态成员 》子类静态成员 》父类实例成员 》父类构造 》子类实例成员 》子类构造
 */
public class B extends A {
//    private String name = "B";
    public B(){
        System.out.println("子类B构造方法");
    }

    /**
     * finanlly修改的方法可以被重载
     */
    public final void eat(){
    }
    public void eat(int a){

    }

    public static void main(String[] args) {
        B b = new B();
    }
}
