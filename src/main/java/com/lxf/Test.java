package com.lxf;


public class Test {

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("普通代码块");
    }

    public static void main(String[] args) {
        //程序调用System.gc()或不调用，垃圾回收器gc最终执行Object类的finalize()方法，最终决定是否回收
//        System.gc();

        //集合的顶级接口
//        Collection

        //
//        StringBuilder

        //
//        Integer a = Integer.valueOf(10);

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
//        String str = "long,xiang,fu";
//        String[] split = str.split(",");

        //一键生成setter方法
//        Person person = new Person();
//        person.setId(0);
//        person.setName("");
//        person.setAge(0);



    }


}
