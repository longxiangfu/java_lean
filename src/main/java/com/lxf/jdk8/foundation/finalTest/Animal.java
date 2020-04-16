package com.lxf.jdk8.foundation.finalTest;

public abstract class Animal {
    private String name;

    public abstract void run();

    public void eat(){
        System.out.println("我在吃");
    }



    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
