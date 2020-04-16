package com.lxf.jdk8;

import lombok.Data;

import java.io.Serializable;

/**
 * 浅拷贝
 * 对象实现Cloneable接口，并且重写Object类的clone()方法
 */
@Data
public class WangWu implements Cloneable, Serializable {
    private Integer sex;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
