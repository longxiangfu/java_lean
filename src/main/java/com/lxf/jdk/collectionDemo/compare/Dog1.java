package com.lxf.jdk.collectionDemo.compare;

/**
 * 内部比较器
 */
public class Dog1 implements Comparable<Dog1>{
    private String name;
    private Integer age;

    @Override
    public int compareTo(Dog1 dog) {
        return this.age - dog.age;
    }

    public Dog1(String name, Integer age){
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
