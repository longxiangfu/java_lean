package com.lxf.jdk.stringDemo;

import com.lxf.jdk.Person;

/**
 * String是不可变类型，方法参数传递过来的是原String对象的副本，对副本的修改，不影响原String对象；
 * StringBuilder是可变类型，方法参数传递过来的是StringBuilder对象的引用，对引用的修改，会修改原StringBuilder对象
 * 包装类都是final的
 * 值传递：基本数据类型、final修饰的类（包装类、String）
 */
public class StringTest1 {
    public static void main(String[] args) {
        String str = new String("laoWang");
        change(str);
        System.out.println(str);//laoWang

        StringBuilder stringBd = new StringBuilder("hi,");
        changeBd(stringBd);
        System.out.println(stringBd);//hi,laoWang

        // StringBuffer是线程安全的，StringBuilder是线程不安全的
        StringBuffer buffer = new StringBuffer("hi,");
        buffer.append("laoWang");

    }

    private static void changeBd(StringBuilder stringBd) {
        stringBd.append("laoWang");
    }

    private static void change(String str) {
        str = "xiaoWang";
    }
}
