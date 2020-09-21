package com.lxf.jdk.foundation.abstractAndInterfaceTest;

import java.io.IOException;

/**
 * 抽象类和接口的区别
 * 1、抽象类封装了公共属性和方法；接口封装了方法
 * 2、继承抽象类用extends;实现接口用implements
 * 3、单继承；多实现
 * 4、都可以有main方法。抽象类中可以有构造方法，接口不能有构造方法
 */
public abstract class AbstractTest {
    //构造
    public AbstractTest(){

    }

    //main方法
    public static void main(String[] args) {

    }

    abstract void test();

    void eat(){

    }


    private void hug(){

    }

    void hug1(){

    }


    void hug2() throws IOException {
        throw new IOException();
    }





}
