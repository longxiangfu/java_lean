package com.lxf.jdk8.foundation.abstractAndInterfaceTest;

import java.io.IOException;

/**
 * 必须重写父类中的抽象方法和父接口中的方法
 * 可以重写父类中的非抽象方法
 */
public class Test extends AbstractTest implements InterfaceTest{
    @Override
    void test() {

    }

    @Override
    public void test1() {

    }

    @Override
    public void eat1() {

    }

    /**
     * 方法重写
     */
//    @Override//可有可无
    void eat(){
        super.eat();
    }

    /**
     * 方法重载
     * @param a
     */
    void eat(int a){

    }

//    @Override  不能重写父类中私有方法，否则只是在子类中重新定义了一个方法（没有向上的箭头，说明是重新定义了一个新方法）
    private void hug(){

    }

    //访问权限不能比父类的小
    public void hug1(){

    }

    //抛出的异常不能比父类大
    void hug2() throws IOException {
        throw new IOException();
    }



}
