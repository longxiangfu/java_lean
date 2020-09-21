package com.lxf.jdk.foundation.enumTest;

/**
 * 枚举类用于switch判断
 */
public class SwitchTest {

    public static void main(String[] args) {
        String result = "我是默认的";
        switch (EnumInnerTest.PlayerType.BASKETBALL){
            case BASKETBALL:
                result = "篮球";
                break;
            case TENNIS:
                result = "台球";
                break;
            case FOOTBALL:
                result = "足球";
                break;
            default:
                throw new RuntimeException("不是类型");
        }
        System.out.println(result);
    }
}
