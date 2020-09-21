package com.lxf.jdk.jdk_E.stream.filter;

import com.lxf.jdk.jdk_E.stream.sorted.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/22 15:40
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        Person p = Person.builder().id(1).name("lxf").age(30).build();
        Person p2 = Person.builder().id(2).name("lxf1").age(35).build();
        Person p3 = Person.builder().id(3).name("lxf2").age(38).build();
        List<Person> pList = new ArrayList<>();
        pList.add(p);
        pList.add(p2);
        pList.add(p3);
        pList.add(p3);

//        //filter():过滤
//        pList.stream().filter(e ->{
//            return e.getAge() > 31;
//        }).forEach(System.out::println);
//
//        //limit():截断
//        pList.stream().limit(1).forEach(System.out::println);
//
//        //skip():与limit()互斥，跳过元素
//        pList.stream().skip(1).forEach(System.out::println);

//        pList.stream().forEach(System.out::println);
        //distinct():去重
//        pList.stream().distinct().forEach(System.out::println);

        //max()  min()  sum()  avg()  count()
//        IntSummaryStatistics num = pList.stream().mapToInt(e -> e.getAge()).summaryStatistics();
//        System.out.println(num.getMax() + " " + num.getMin() + " " + num.getSum() + " " + num.getAverage() + " " + num.getCount());

        //findFirst():获取第一个元素
        Person pFirst = pList.stream().findFirst().get();
        System.out.println(pFirst);
    }
}
