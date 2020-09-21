package com.lxf.jdk.collectionDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetTest {
    public static void main(String[] args) {
        //
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(Arrays.toString(hashSet.toArray()));//[null, 1]

        //
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);

    }
}
