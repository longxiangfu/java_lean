package com.lxf.jdk.toolClass;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * commons-collections4类库
 */
public class CommonsCollections4 {

    public static void main(String[] args) {
        // 集合判空
//        List<Integer> list = new ArrayList<>();
//        CollectionUtils.isEmpty(list);
//        CollectionUtils.isNotEmpty(list);

        // 集合的交集  并集  差集
        List<Integer> listA = new ArrayList<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        List<Integer> listB = new ArrayList<>();
        listB.add(2);
        listB.add(3);
        System.out.println("交集：" + CollectionUtils.retainAll(listA, listB)); // 交集：[2, 3]
        System.out.println("并集：" + CollectionUtils.union(listA, listB)); // 并集：[1, 2, 3]
        System.out.println("差集：" + CollectionUtils.subtract(listA, listB)); // 差集：[1]
    }
}
