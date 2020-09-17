package com.lxf.jdk8.foundation.simpleName;

/**
 * 获取一个类和其实现类的SimpleName
 */
public class Test {

    public static void main(String[] args) {
        try {
            Class fruitClass = Class.forName("com.lxf.jdk8.foundation.simpleName.Fruit");
            Class appleClass = Class.forName("com.lxf.jdk8.foundation.simpleName.AppleFruit");
            System.out.println("fruitClass:" + fruitClass.getSimpleName());//fruitClass:Fruit
            System.out.println("appleClass:" + appleClass.getSimpleName());//appleClass:Apple
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
