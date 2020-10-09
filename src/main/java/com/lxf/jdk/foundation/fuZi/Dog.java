package com.lxf.jdk.foundation.fuZi;

import lombok.Data;

@Data
public class Dog extends Animal {
    public static String sex = "nan";//类属性（静态属性）
    private String name = "dog";//实例属性（动态属性）

    public Dog(){
        System.out.println("子构造器");
    }
}
