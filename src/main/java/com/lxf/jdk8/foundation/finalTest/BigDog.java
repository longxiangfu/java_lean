package com.lxf.jdk8.foundation.finalTest;

public class BigDog extends Dog{
    @Override
    public void run() {
        //final修饰的方法不能被重写
    }
}
