package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi8;

/**
 * 1、类只能单继承，因为多继承的话，可能多个父类有相同的方法，那么子类就不知道调用哪个父类的方法，类的单继承解决了这个问题
 * 2、以前接口只有抽象方法，而jdk8又有了default和static方法，他们都是可以有方法体的，那是如何解决类似类的问题的呢，
 * 解决的方法：实现类必须重写
 */
public class ImplementClass implements InterfaceA, InterfaceB {

    public static void main(String[] args) {
        ImplementClass implementClass = new ImplementClass();
        implementClass.defaultMethod();
        InterfaceA a = new ImplementClass();
        a.defaultMethod();
        InterfaceB b = new ImplementClass();
        b.defaultMethod();
//        I am defaultMethod
//        I am defaultMethod
//        I am defaultMethod


    }


    /**
     * 实现两个接口，并且这两个接口都有相同的方法，那么实现类必须实现该方法
     */
    @Override
    public void defaultMethod() {
        System.out.println("I am defaultMethod");
    }
}
