package com.lxf.jdk.toolClass;

import com.google.common.collect.*;

import java.util.*;

/**
 * guava类库
 */
public class guava {

    public static void main(String[] args) {
        // 集合
//        List<String> list = Lists.newArrayList();
//        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> reverseList = Lists.reverse(list1); // 反转
//        List<List<Integer>> partition = Lists.partition(list1, 2); // 划分集合，每份2个元素
//        // Map  Set
//        Map<String, String> map = Maps.newHashMap();
//        Set<String> set = Sets.newHashSet();

        // ArrayListMultimap：一个key对应多个value的HashMap
//        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
//        multimap.put("key", 1);
//        multimap.put("key", 2);
//        System.out.println(multimap.get("key")); // [1, 2]
//        Map<String, Collection<Integer>> asMap = multimap.asMap(); // 返回以前那种map

        //
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("key", "value");
        biMap.put("key", "value");
//        biMap.forcePut("key", "value");
        System.out.println(biMap);


    }
}
