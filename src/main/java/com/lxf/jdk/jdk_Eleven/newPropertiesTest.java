//package com.lxf.jdk.jdk_Eleven;
//
//import java.util.function.Consumer;
//
///**
// * 新特性测试
// */
//public class newPropertiesTest {
//
//    public static void main(String[] args) {
////        localVar();
//        stringTest();
//    }
//
//    /**
//     * String新的api
//     */
//    private static void stringTest() {
//        String str = "  sssslonsonf   ";
//        System.out.println(str.isEmpty());
//        System.out.println(str.isBlank());
//        System.out.println(str.strip());//去除左右空白
//        System.out.println(str.stripTrailing());//去除尾部空白
//        System.out.println(str.stripLeading());//去除头部空白
//        System.out.println(str.repeat(2));//复制几遍字符串
//        System.out.println(str.lines().count());//行数统计
////        false
////        false
////        sssslonsonf
////                sssslonsonf
////        sssslonsonf
////        sssslonsonf     sssslonsonf
////        1
//    }
//
//    /**
//     * 局部变量类型推断
//     */
//    private static void localVar() {
//        var t = "lovalVariable";
//        Class<? extends String> tClass = t.getClass();
//        System.out.println("cClass:" + tClass);
//
//        Consumer<String> consumer = a -> System.out.println(a.toUpperCase());
//        consumer.accept("aaDslFF");
//    }
//}
