package com.lxf.jdk.foundation.innerClass.anonymousClass;

/**
 * 匿名内部类
 * 1.匿名内部类必须实现一个接口，或实现一个父类
 * 2.内名内部类不能定义任何静态成员和方法
 * 3.匿名内部类中的方法不能是抽象的
 */
public class Outer {
    private String name = "Outer class";
    private static Integer index = 10;

    public Outer(){
        System.out.println("Outer class");
    }

    public void sayHi(){
        AnonymousInterface anonymousInterface = new AnonymousInterface() {
//            private static Integer count = 0;
//            private static void hello(){
//
//            }
//            private abstract void hi();
            @Override
            public void hi() {
                System.out.println("hi, anonymousInnerClass");
                //内部类使用外部类属性和方法
                System.out.println(Outer.this.name);
                Outer.this.eat();
                System.out.println(Outer.index);
                Outer.hug();
            }

            @Override
            public void hi1() {

            }
        };
        //匿名内部类的调用
        anonymousInterface.hi();

        AnonymousAbstractClass anonymousAbstractClass = new AnonymousAbstractClass() {
            @Override
            void eat() {

            }

            @Override
            void eat1() {

            }
        };
    }

    public void eat(){
        System.out.println("eat");
    }

    public static void hug(){
        System.out.println("hug");
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.sayHi();
    }


}
