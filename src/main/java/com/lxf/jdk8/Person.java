package com.lxf.jdk8;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 实现Serializable:以便序列化和反序列化，实现浅拷贝
 * 实现Cloneable，并且重写Object类的clone()方法，实现浅拷贝和深拷贝
 * @Author Administrator
 * @DATE 2019/4/15 14:37
 * @Version 1.0
 **/
@Data
public class Person implements Cloneable, Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private WangWu wangWu;

    public Object clone() throws CloneNotSupportedException {
        //只能实现浅拷贝
        return super.clone();

        //可以实现深拷贝
//        Person person = (Person) super.clone();
//        person.wangWu = (WangWu)person.wangWu.clone();
//        return person;
    }


}
