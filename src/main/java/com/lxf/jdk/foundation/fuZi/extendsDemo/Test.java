package com.lxf.jdk.foundation.fuZi.extendsDemo;

/**
 * 测试属性和方法的继承和重写
 */
public class Test {
    public static void main(String[] args) {
        AppleTree appleTree = new AppleTree();
        //子类可以继承父类的属性(实例属性和静态属性)
        System.out.println(appleTree.weight);
        System.out.println(appleTree.height);
        //属性是可以重写的(实例属性和静态属性)
        System.out.println(appleTree.color);
        //子类可以继承父类的方法（实例方法和静态方法）
        appleTree.grow();
        //方法是可以重写的（实例方法和静态方法）
        appleTree.grow1();


        // 继承、多态
        Plant plant = new AppleTree(); // 这种写法无法调用子类特有的方法
        plant.grow();
        plant.grow1();
//        plant.grow2();
    }
}
