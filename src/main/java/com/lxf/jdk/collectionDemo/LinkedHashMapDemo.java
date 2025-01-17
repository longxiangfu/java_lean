package com.lxf.jdk.collectionDemo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        viewInsertSort();
        viewSelectSort();
    }


    /**
     * 观察按访问顺序排序
     */
    private static void viewSelectSort() {
        // 访问顺序（按访问顺序进行排序，即将最近访问的node放到最后）
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap(16, 0.75f, true);
        linkedHashMap1.put("4", 4);
        linkedHashMap1.put("5", 5);
        linkedHashMap1.put("6", 6);
        linkedHashMap1.get("4");
        Set<Map.Entry<String, Integer>> entries = linkedHashMap1.entrySet();
        Iterator iterator =entries.iterator();
        System.out.println("LinkedList按访问顺序排序");
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry1 = (Map.Entry)iterator.next();
            System.out.println(String.format("key:%s, value:%d", entry1.getKey(), entry1.getValue()));
//            key:5, value:5
//            key:6, value:6
//            key:4, value:4
        }
    }


    /**
     * 观察按插入顺序排序
     */
    private static void viewInsertSort() {
        //插入顺序(按插入顺序排序)
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("1", 1);
        linkedHashMap.put("2", 2);
        linkedHashMap.put("3", 3);
        Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
        Iterator iterator =entries.iterator();
        System.out.println("LinkedList按插入顺序排序");
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry)iterator.next();
            System.out.println(String.format("key:%s, value:%d", entry.getKey(), entry.getValue()));
//            key:1, value:1
//            key:2, value:2
//            key:3, value:3
        }
    }
}
