package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi5;

public class AnimalImpl implements IAnimal {
    String name = "heide";
    static String age = "20";

    public static void main(String[] args) {
        //default方法属于实例方法，必须通过实例调用（相当于是实现了接口的方法）
        AnimalImpl animal = new AnimalImpl();
        animal.printAge();

        //static方法，可以通过接口直接调用（不能实现接口的静态方法）
        IAnimal.printName();

        //实现了接口的成员属性和静态成员属性
        System.out.println(AnimalImpl.age);
//        System.out.println(AnimalImpl.name);
        animal.eat();
    }


    @Override
    public void eat() {
        name = "heide";
        System.out.println(name);
    }

    @Override
    public void hug() {

    }
}
