package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi5;

public class AnimalImpl implements IAnimal {
    String name = "heide";
    static String age = "20";

    public static void main(String[] args) {
        //default方法属于实例方法，必须通过实例调用（相当于是实现了接口的方法）
        AnimalImpl animal = new AnimalImpl();//===1   这两种方式都是先看父类（父接口），然后再看本类
        animal.printAge();
        IAnimal iAnimal = new AnimalImpl();//===2
        iAnimal.printAge1();

        //static方法，可以通过接口直接调用（不能实现接口的静态方法）
        IAnimal.printName();

        //和抽象类一样，属性可以继承，但是不能实现，
        // 能实现的是方法，方法既能继承也能重写。
        System.out.println("AnimalImpl.age：" + AnimalImpl.age);
        System.out.println("IAnimal.age:" + IAnimal.age);

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

    public void printAge(){
        System.out.println("188");
    }

    public void printAge1(){
        System.out.println("200");
    }

}
