package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi7;

public abstract class AbstactClass {
    /**
     * 方法分为抽象方法和非抽象方法
     */
    abstract void test1();
    void test2(){

    }

    /**
     * 抽象方法不能是静态的；非抽象方法可以是静态的
     */
//    abstract static void test3();//抽象方法不能是静态的
    static void test4(){

    }


    /**
     * 抽象方法可以public protected 默认，不能用private修饰
     * 非抽象方法都可以，public protected 默认 private
     */
    public abstract void test5();
    protected abstract void test6();
    abstract void test7();
//    private abstract void test8();
    private void test9(){

    }


    public static void main(String[] args) {

    }




}
