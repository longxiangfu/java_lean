package com.lxf.jdk.stringDemo;

import java.util.Objects;

/**
 * 比较两个字符串相等
 */
public class StringTest6 {

    public static void main(String[] args) {
        String a = null;
        String b = "b";

        // 一般是这样判断
//        if (a.equals(b)) {
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }

        // 有时候字符串a可能为null,那么判断就会报错
        // 所以通用的判断两个对象是否相等
        if (Objects.equals(a, b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
