package com.lxf.jdk8.foundation.generic.application;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson库中的泛型使用
 * java.lang.reflect.Type，是所有类型的高级接口
 */
public class GsonGeneric {
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            personList.add(new Person("name" + i, 18 + i));
        }
        // Serialization
        String json = gson.toJson(personList);
        System.out.println(json);
        // Deserialization
        Type personType = new TypeToken<List<Person>>() {}.getType();
        List<Person> personList2 = gson.fromJson(json, personType);
        gson.fromJson(json, Person.class);
        System.out.println(personList2);
    }
}
