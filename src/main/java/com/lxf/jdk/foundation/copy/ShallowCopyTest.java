package com.lxf.jdk.foundation.copy;

import com.lxf.jdk.Person;
import com.lxf.jdk.WangWu;

/**
 * 浅拷贝
 * 对象实现Cloneable接口，并且重写Object类的clone()方法
 */
public class ShallowCopyTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        //测试String类型属性是否拷贝  true
        //测试对象属性是否拷贝  false
        Person p = new Person();
        p.setName("陈婷");
        WangWu wangWu = new WangWu();
        wangWu.setSex(1);
        p.setWangWu(wangWu);

        Person pCopy = (Person) p.clone();
        pCopy.setName("龙相甫");
        pCopy.getWangWu().setSex(2);

        //origin name|wangwu.sex:陈婷|2。 new name|wangwu.sex:龙相甫|2   ----2  2
        System.out.println("origin name|wangwu.sex: " + p.getName() + "|" + p.getWangWu().getSex()
                + "。 new name|wangwu.sex: " + pCopy.getName() + "|" + pCopy.getWangWu().getSex());

    }
}
