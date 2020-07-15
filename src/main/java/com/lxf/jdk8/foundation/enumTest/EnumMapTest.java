package com.lxf.jdk8.foundation.enumTest;

import java.util.EnumMap;

/**
 * EnumMap
 * 效率比HashMap还要高
 */
public class EnumMapTest {

    public static void main(String[] args) {
        EnumMap<EnumSetTest.PlayerType, String> enumMap = new EnumMap<>(EnumSetTest.PlayerType.class);
        enumMap.put(EnumSetTest.PlayerType.BASKETBALL, "篮球");
        enumMap.put(EnumSetTest.PlayerType.TENNIS, "台球");
        enumMap.put(EnumSetTest.PlayerType.FOOTBALL, "足球");
        System.out.println(enumMap);

        System.out.println(enumMap.get(EnumSetTest.PlayerType.BASKETBALL));
        System.out.println(enumMap.get(EnumSetTest.PlayerType.TENNIS));
        System.out.println(enumMap.get(EnumSetTest.PlayerType.FOOTBALL));

    }

}
