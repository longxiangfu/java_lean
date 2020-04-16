package com.lxf.jdk8.foundation.enumTest;

/**
 * 1、枚举类重写了equals(),内部是用==判断的
 * 2、枚举类不能用new创建对象，而ColorsEnum创建出来的对象，其实是ColorsEnum的引用
 */
public class Test {
    public static void main(String[] args) {
        ColorsEnum colorsEnum = ColorsEnum.RED;
        ColorsEnum colorsEnum2 = ColorsEnum.RED;
        System.out.println(colorsEnum == colorsEnum2);//true
        System.out.println(colorsEnum.equals(colorsEnum2));//true
    }
}
