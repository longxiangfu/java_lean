package com.lxf.jdk8.foundation.abstractAndInterfaceTest;

/**
 * 先父类再子类
 * 父类静态成员 》子类静态成员 》父类实例成员 》父类构造 》子类实例成员 》子类构造
 */
public class ExecTest {
    public static void main(String[] args) {
        Son son = new Son();//251346
    }

    static class Parent{
        //实例代码块
        {
            System.out.print("1");
        }
        static{
            System.out.print("2");
        }
        public Parent(){
            System.out.print("3");
        }
    }
    static class Son extends Parent{
        {
            System.out.print("4");
        }
        static{
            System.out.print("5");
        }
        public Son(){
            System.out.print("6");
        }
    }
}
