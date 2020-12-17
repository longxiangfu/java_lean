package com.lxf.jdk.foundation.fuZi.staticDemo;

public class staticBlock {
    static int stMember = 100;


    public static void main(String args[]){
        System.out.println("This is main method.");
    }


    //第一个静态代码块
    static{
        System.out.println("第一个静态代码块中修改前的stMember：" + stMember);//100
        System.out.println("This is first static block.");
        stMember  = 200;
        System.out.println("第一个静态代码块中修改后的stMember：" + stMember);//200
        staticBlock oa = new staticBlock();
        System.out.println("stMember = " + oa.stMember);
        statFun();
    }


    //定义一个静态方法
    static void statFun(){
        System.out.println("This is a static method.");
    }


    //第二个静态代码块
    static{
        System.out.println("This is second static block.");
        System.out.println("第二个静态代码块中的stMember：" + stMember);//200
    }
}
