package com.lxf.jdk8.foundation.innerClass.staticMemberInnerClass;

/**
 * 静态成员内部类
 * 1.静态内部类中不能访问非静态的外部类对象（同静态方法中不能访问实例方法一样）
 */
public class Outer {
    private String name = "Outer class";
    private static Integer index = 10;

    public Outer(){
        System.out.println("Outer class");
    }

    private void sayHi(){
        System.out.println("hi, Outer");
        //外部类访问内部类属性和方法（属性和方法可以是私有的）
        Inner2 inner = new Inner2();
        System.out.println(inner.name);//内部类实例成员
        inner.eat();//内部类实例方法
    }

    public static void eat(){
        System.out.println("Outer eat");
    }



    static class Inner2 {
        private String name = "Inner2 class";
        private static Integer index = 10;//非静态类，不允许有静态成员

        public Inner2() {
            System.out.println("Inner2 class");
        }

        public void sayHi() {
            System.out.println("hi, Inner2");
            //内部类访问外部类属性和方法（属性和方法可以是私有的）
            /*
            静态成员内部类中不能访问非静态外部类对象
             */
//            System.out.println("Outer.this.name:" + Outer.this.name);//外部类实例成员
//            Outer.this.sayHi();//外部类实例方法
            System.out.println("Outer.index:" + Outer.index);//外部类静态成员
            Outer.eat();//外部类静态方法
        }

        private void eat() {
            System.out.println("Inner2 eat");
        }

        public static void hug() {

        }

    }



}
