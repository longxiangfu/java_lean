package com.lxf.jdk8.foundation.enumTest;

import java.util.EnumSet;

/**
 * EnumSet
 * 内部实现的位向量（待研究）
 */
public class EnumSetTest {

    private EnumInnerTest.PlayerType type;

    public enum PlayerType{
        TENNIS,
        FOOTBALL,
        BASKETBALL
    }


    public static void main(String[] args) {
        EnumSet<PlayerType> playerTypes = EnumSet.noneOf(PlayerType.class);
        System.out.println(playerTypes);//[]

        EnumSet<PlayerType> playerTypes1 = EnumSet.allOf(PlayerType.class);
        System.out.println(playerTypes1);//[TENNIS, FOOTBALL, BASKETBALL]

        EnumSet<PlayerType> playerType2 = EnumSet.of(PlayerType.BASKETBALL, PlayerType.FOOTBALL);
        System.out.println(playerType2);//[FOOTBALL, BASKETBALL]

        //可以操作Set的方法
        playerTypes.add(PlayerType.TENNIS);
        System.out.println(playerTypes);

    }

}
