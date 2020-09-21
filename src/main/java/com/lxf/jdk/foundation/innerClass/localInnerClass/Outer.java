package com.lxf.jdk.foundation.innerClass.localInnerClass;

/**
 * 局部内部类
 * 1.局部内部类不能使用任何访问修饰符
 */
public class Outer {
    private String name = "Outer class";
    private static Integer index = 10;

    public Outer(){
        System.out.println("Outer class");
    }

    private void sayHi(){
        int i = 0;
        System.out.println("hi, Outer");
        //局部内部类：定义在方法内
        class Inner{//不能有任何修饰符
            Inner(String name){
                System.out.println(i);//直接访问方法中的局部变量
                System.out.println("hi, Inner:" + name);
                //访问外部类属性和方法
                System.out.println(Outer.this.name);
                Outer.this.hug();
                System.out.println(Outer.index);
                Outer.eat();
            }
        }
        //局部内部类创建
        System.out.println(new Inner(name));
    }

    public static void eat(){
        System.out.println("Outer eat");
    }

    public void hug(){
        System.out.println("Outer hug");
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.sayHi();
    }


}
