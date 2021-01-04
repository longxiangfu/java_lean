package com.lxf.jdk.foundation.fuZi.huxiangdiaoyong.fuToZi;

public abstract class People {

    public void eat(){
        System.out.println("People eat");
        eatApple();//实际上调用实现类的重写方法
    }

    public abstract void eatApple();

}
