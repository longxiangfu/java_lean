package com.lxf.jdk8.foundation.enumTest;

/**
 * 内部枚举测试
 */
public class EnumInnerTest {

    private PlayerType type;

    /**
     * 内部枚举
     */
    public enum PlayerType{
        TENNIS,
        FOOTBALL,
        BASKETBALL
    }


    /**
     * 判断是否是篮球
     * @return
     */
    public boolean isBasketBall(){
        return getType() == PlayerType.BASKETBALL;
    }


    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }


    public static void main(String[] args) {
        EnumInnerTest test = new EnumInnerTest();
        test.setType(PlayerType.BASKETBALL);
        boolean basketBall = test.isBasketBall();
        System.out.printf("是否是篮球：" + basketBall);
    }
}
