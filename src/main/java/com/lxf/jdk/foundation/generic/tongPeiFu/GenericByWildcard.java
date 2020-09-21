package com.lxf.jdk.foundation.generic.tongPeiFu;

import com.lxf.jdk.foundation.generic.GenericClass;

/**
 * 泛型通配符
 */
public class GenericByWildcard {
    private static void print(GenericClass<Fruit> fruitGenericClass){
        System.out.println(fruitGenericClass.getData().getClor());
    }
    private static void use(){
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        print(fruitGenericClass);
        //类型不匹配
//        GenericClass<Orange> orangeGenericClass = new GenericClass<>();
//        print(orangeGenericClass);
    }


    //指定泛型类型的上界,用extends
    private static void printExtends(GenericClass<? extends Fruit> genericClass){
        System.out.println(genericClass.getData().getClor());
    }
    private static void useExtends(){
        //1
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        printExtends(fruitGenericClass);
        GenericClass<Orange> orangeGenericClass = new GenericClass<>();
        printExtends(orangeGenericClass);
        GenericClass<HongFuShi> hongFuShiGenericClass = new GenericClass<>();
        printExtends(hongFuShiGenericClass);
        //Food超出了上界（Fruit）范围
//        GenericClass<Food> foodGenericClass = new GenericClass<>();
//        printExtends(foodGenericClass);

        //2
        //get获取的一定是Fruit
        // set的入参是Fruit的子类，但具体是什么，不知道
        //用于安全的访问数据，访问Fruit及其子类
        GenericClass<? extends Fruit> extendsFruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
//        extendsFruitGenericClass.setData(fruit);
//        extendsFruitGenericClass.setData(apple);

        Fruit fruitGenericClassData = extendsFruitGenericClass.getData();
    }


    //指定泛型类型下界，用super
    private static void printSuper(GenericClass<? super Apple> genericClass){
        System.out.println(genericClass.getData());
    }
    private static void useSuper(){
        //1
        GenericClass<Food> foodGenericClass = new GenericClass<>();
        printSuper(foodGenericClass);
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        printSuper(fruitGenericClass);
        GenericClass<Apple> appleGenericClass= new GenericClass<>();
        printSuper(appleGenericClass);
        //HongFuShi超出了下界Apple
//        GenericClass<HongFuShi> hongFuShiGenericClass = new GenericClass<>();
//        printSuper(hongFuShiGenericClass);

        //2
        //get获取到的是Apple的超类，具体是什么，不知道，但Object肯定能接收到
        //set的入参是Apple的超类，具体是什么，不知道，但Apple及其子类，可以安全地造型为Apple
        //用于安全地写入数据，写入Apple及其子类
        GenericClass<? super Apple> superAppleGenericClass = new GenericClass<>();
        superAppleGenericClass.setData(new Apple());
        superAppleGenericClass.setData(new HongFuShi());
//        superAppleGenericClass.setData(new Fruit());

        Object data = superAppleGenericClass.getData();
    }


    //无限定的通配符
    private static void printNoLimit(GenericClass<?> genericClass){
        System.out.println(genericClass.getData());
    }
    private static void userNoLimit(){
        //1
        GenericClass<Food> foodGenericClass = new GenericClass<>();
        printNoLimit(foodGenericClass);
        GenericClass<HongFuShi> hongFuShiGenericClass = new GenericClass<>();
        printNoLimit(hongFuShiGenericClass);
        //2
        //get只能只能用Object接收
        //set不能被调用
        GenericClass<?> genericClass = new GenericClass<>();
//        genericClass.setData(new Food());
//        genericClass.setData(new Object());

        Object data = genericClass.getData();
    }






}
