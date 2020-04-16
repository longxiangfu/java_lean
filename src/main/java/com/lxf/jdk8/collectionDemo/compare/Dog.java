package com.lxf.jdk8.collectionDemo.compare;

/**
 * 内部比较器
 */
public class Dog implements Comparable<Dog>{
    private String name;
    private Integer age;

    @Override
    public int compareTo(Dog dog) {
        return this.age - dog.age;
    }

    public Dog(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public Integer getAge(){
        return this.age;
    }

}
