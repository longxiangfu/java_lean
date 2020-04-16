package com.lxf.jdk8.foundation.generic;

/**
 * 泛型方法一
 */
public class GenericMethod1 {

    private static <T> T add(T a, T b){
        System.out.println(a + "+" + b + "="+a+b);
        return a;
    }

    public static void main(String[] args) {
        GenericMethod1.add(1, 2);
        GenericMethod1.add("a", "b");
    }

}
