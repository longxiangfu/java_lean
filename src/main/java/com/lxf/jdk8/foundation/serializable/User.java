package com.lxf.jdk8.foundation.serializable;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5528344928563231734L;
    private String name;
    private int age;
    @Override
    public String toString() {
        return "{name:" + name + ",age:" + age + "}";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
