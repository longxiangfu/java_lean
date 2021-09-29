package com.lxf.jdk.collectionDemo;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListDemo {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(Arrays.toString(list.toArray()));//[1, 2, 3]
//        //替换
//        list.replaceAll(e -> e+10);
//        list.stream().forEach(e ->{
//            System.out.println(e);
//        });
//
//        //排序
//        list.sort((a1, a2) -> a2 - a1);
//        list.stream().forEach(e ->{
//            System.out.println(e);
//        });
//
//        //移除
//        list.removeIf(e -> e == 2);
//        list.stream().forEach(e ->{
//            System.out.println(e);
//        });


//        //分隔迭代器    元素分隔后分别进行运算，之后可以并行计算。
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        list1.add("4");
//        list1.add("5");
//        list1.add("6");
//        list1.add("7");
//        list1.add("8");
//        list1.add("9");
//        list1.add("10");
//        list1.add("11");
//        list1.add("12");
//        Spliterator spliterator1 = list1.spliterator();//12
//        Spliterator spliterator2 = spliterator1.trySplit();//6   6
//        Spliterator spliterator3 = spliterator1.trySplit();//3   3
//        Spliterator spliterator4 = spliterator2.trySplit();//3   3
//        spliterator1.forEachRemaining(e -> System.out.println(e));
//        System.out.println("--------------");
//        spliterator2.forEachRemaining(e -> System.out.println(e));
//        System.out.println("--------------");
//        spliterator3.forEachRemaining(e -> System.out.println(e));
//        System.out.println("--------------");
//        spliterator4.forEachRemaining(e -> System.out.println(e));


//        //判断是否可以添加null
//        list1.add(null);

//        //Collection是集合顶级接口（最顶级是Iterator）,定义了集合的一些基本操作，如size(),isEmpty(),containss()等
//        //Collections是集合工具类，进行集合排序、线程安全操作等
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        Collections.reverse(list);//[b, a]
//        Collections.sort(list);
//        Collections.synchronizedList(list);
//        if (list != null && !list.isEmpty()) {
//
//        }
//        if(CollectionUtils.isEmpty(list)){
//
//        }
//        System.out.println(Arrays.toString(list.toArray()));


        //ArrayList和LinkedList从中间插入，比较时间
        //从中间插入时间差不多，ArrayList需要复制新元素之后的所有元素；LinkedList需要从链前或链后找到新元素插入的位置
//        List<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(7);
//        arrayList.add(8);
//        arrayList.add(9);
//        arrayList.add(5, 10);
//
//        List<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(5);
//        linkedList.add(6);
//        linkedList.add(7);
//        linkedList.add(8);
//        linkedList.add(9);
//        linkedList.add(null);//List可以有多个null值
//        linkedList.add(null);
//        linkedList.add(5, 10);


        // 集合元素拼接成以逗号分隔的字符串
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        String join = list.stream().collect(Collectors.joining(","));
//        String join1 = String.join(",", list);
//        System.out.println("join:" + join); // join:a,b,c
//        System.out.println("join1:" + join1); // join1:a,b,c


    }
}
