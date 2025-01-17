package com.lxf.jdk.oop;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("name");

        Person person1 = person; // 引用传递
        person1.setName("name1");

        System.out.println(person); // Person(id=null, name=name1)
        System.out.println(person1); // Person(id=null, name=name1)
    }
}
