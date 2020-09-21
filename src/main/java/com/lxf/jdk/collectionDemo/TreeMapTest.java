package com.lxf.jdk.collectionDemo;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        //TreeMap实现按value倒排序
        TreeMap treeMap = new TreeMap();
        treeMap.put("dog", "dog");
        treeMap.put("cat", "cat");
        treeMap.put("ant", "ant");
        List<Map.Entry<String, String>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, String> item : list
             ) {
            System.out.println(item.getValue());
        }
    }
}
