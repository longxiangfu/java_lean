package com.lxf.jdk8.stream.sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description sorted操作
 * @Author Administrator
 * @DATE 2019/4/16 15:16
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        Stream list = Arrays.stream(new Integer[]{1,2,3,4,5});
        //自然排序
//        list.sorted().forEach(e -> {
//            System.out.println(e);
//        });

        //自然逆序
        list.sorted(Comparator.reverseOrder()).forEach(e ->{
            System.out.println(e);
        });

        //自定义排序规则
        Person p = Person.builder().id(1).name("lxf").age(30).build();
        Person p2 = Person.builder().id(2).name("lxf1").age(35).build();
        List<Person> pList = new ArrayList<>();
        pList.add(p);
        pList.add(p2);
//        pList.stream().sorted(Comparator.comparing(Person::getAge)).forEach(e ->{
//            System.out.println(e);
//        });

        //将上面的排序结果逆序
        pList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(person -> {
            System.out.println(person);
        });
    }
}
