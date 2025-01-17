package com.lxf.jdk;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 实现Serializable:以便序列化和反序列化，实现深拷贝
 * 实现Cloneable，并且重写Object类的clone()方法，实现浅拷贝
 * @Author Administrator
 * @DATE 2019/4/15 14:37
 * @Version 1.0
 **/
@Data
public class Person implements Cloneable, Serializable {
    private static final long serialVersionUID = 9003018169432235531L;
    private Integer id;
    private String name;
    private Integer age;
    private WangWu wangWu;

    public Object clone() throws CloneNotSupportedException {
        //只能实现浅拷贝
        return super.clone();
    }


}
