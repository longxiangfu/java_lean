package com.lxf;

public class Test {
    public static void main(String[] args) {
        //程序调用System.gc()或不调用，垃圾回收器gc最终执行Object类的finalize()方法，最终决定是否回收
        System.gc();

        //集合的顶级接口
//        Collection

        //
//        StringBuilder

        //
        Integer a = Integer.valueOf(10);

        //包装类都是final修饰的
//        Byte
//        Boolean
//        Character
//        Short
//        Integer
//        Long
//        Float23q1aeeeeeeeeeee `
//        Double

        //测试String#Spilit
        String str = "long,xiang,fu";
        String[] split = str.split(",");


    }


}
