package com.lxf.jdk8.foundation.abstractAndInterfaceTest;

public class Test1 {
    private String name;
    private static String sex;

    public static void main(String[] args) {

    }

    /**
     * 静态方法中不允许使用实例成员变量和实例方法；
     * 静态方法中不允许使用this和super
     */
    public static void eat(){
//        name = "";
//        hug();
//        this.name;
//        super.equals();
    }

    /**
     * 实例方法中可以使用静态变量和静态方法
     */
    public void hug(){
        sex = "nan";
        eat();
    }
}
