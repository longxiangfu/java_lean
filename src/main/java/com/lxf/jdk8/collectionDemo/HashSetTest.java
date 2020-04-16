package com.lxf.jdk8.collectionDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetTest {
    public static void main(String[] args) {
        //
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(null);
        hashSet.add(null);

        //
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);

    }
}
