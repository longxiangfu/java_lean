package com.lxf.jdk.foundation.fuZi;

import lombok.Data;

@Data
public class Dog extends Animal {
    public static String sex = "nan";//类属性（静态属性）
    private String name = "dog";//实例属性（动态属性）

    public Dog(){
        super();//默认会有
        System.out.println("子构造器");
    }

    /**
     * 子类的构造函数无法继承父类的构造函数。
     * 将此构造方法注释掉，将无法Dog dog1 = new Dog("beibei")，即使父类有同样的构造方法
     * 而python的初始化方法类似java中的普通的方法，是可以被子类继承的
     * @param name
     */
    public Dog(String name){
        super();//默认会有
//        super("");//需要手动掉，并且和supper()冲突
        this.name = name;
    }
}
