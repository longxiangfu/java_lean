package com.lxf.jdk.foundation.fuZi;

public class Animal {
    private static String sex = "nv";
    private String name = "animal";

    public Animal(){
        System.out.println("父构造器");
    }

    public Animal(String name){
        this.name = name;
    }

}
