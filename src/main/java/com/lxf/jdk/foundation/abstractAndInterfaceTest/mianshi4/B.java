package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi4;

/**
 * 抽象类
 */
public abstract class B extends A {
    //子类中的抽象方法是可以和父类中的抽象方法同名的
    abstract void a();//可以用public protected 默认

    abstract void b();//抽象方法不能是private static final

    //抽象类中可以包含成员变量、静态成员变量、访问类型可以任意指定
    String name;
    static String sex;
    protected Integer age;

    private static final void eat(){

    }
}
