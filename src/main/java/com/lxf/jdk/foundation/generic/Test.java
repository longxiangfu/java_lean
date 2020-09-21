package com.lxf.jdk.foundation.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        typeClear();
        different();
        different1();
        different2();
    }

    private static void different2() {
        //List\List<Object>都可以存储任意类型的数据，但是List<Object>会触发编译器的类型安全检查
        ArrayList<String> arrayList = new ArrayList<>();
        List list = arrayList;
//        List<Object> objectList = arrayList;
    }

    private static void different1() {
        //List<String>不可以赋值给List<Object>,报类型不匹配
        List<Object> objectList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
//        objectList = stringList;
    }

    private static void different() {
        //List<Object>被赋值后，可以再进行添加
        //List<?>被赋值之后，不能再进行添加
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        List<Object> objectList = arrayList;
        objectList.add("B");
        objectList.remove("A");

        List<?> list = arrayList;
//        list.add("C");
        list.remove("A");
    }

    private static void typeClear() {
        //编译后，会进行类型擦除，变成Object
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        System.out.println(list.getClass() == list1.getClass());
    }
}
