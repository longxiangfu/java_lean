package com.lxf.jdk8.collectionDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * CME:初始化ArrayList时，modCount(实际修改次数)和expectedModCount(期望修改次数)相等，都为4,
 * 当调用List.remove()时，modCount加1，然后ArrayList$Itr.checkForComodification
 * （实际底层是内部类Iterator迭代器进行迭代）中判断，modCount和expectedModCount不相等，抛出异常
 * 解决方法：1.使用Iterator.remove()
 * 2.使用CopyAndWriteArrayList:修改时，底层时复制--修改--赋值，
 * 见D:\java_lean\src\main\java\com\lxf\jdk8\concurrent\CopyOnWriteArrayListTest.java
 */
public class CMETest {
    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};
        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                //调用ArrayList.remove(),实际底层是内部类Iterator迭代器进行迭代
                userNames.remove(userName);
            }
        }
        System.out.println(userNames);
    }
}
