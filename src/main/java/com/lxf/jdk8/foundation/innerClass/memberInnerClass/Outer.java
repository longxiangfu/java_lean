package com.lxf.jdk8.foundation.innerClass.memberInnerClass;

/**
 * 成员内部类
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
        Inner inner = new Inner();
        System.out.println(inner.name);//内部类实例成员
        inner.eat();//内部类实例方法
    }

    public static void eat(){
        System.out.println("Outer eat");
    }



    class Inner{
        private String name = "Inner class";
//        private static Integer index = 10;//非静态类，不允许有静态成员

        public Inner(){
            System.out.println("Inner class");
        }

        public void sayHi(){
            System.out.println("hi, Inner");
            //内部类访问外部类属性和方法（属性和方法可以是私有的）
            System.out.println("Outer.this.name:" + Outer.this.name);//外部类实例成员
            Outer.this.sayHi();//外部类实例方法
            System.out.println("Outer.index:" + Outer.index);//外部类静态成员
            Outer.eat();//外部类静态方法
        }

        private void eat(){
            System.out.println("Inner eat");
        }

//        public static void hug(){//非静态类不允许有静态方法
////
////        }
    }

}
