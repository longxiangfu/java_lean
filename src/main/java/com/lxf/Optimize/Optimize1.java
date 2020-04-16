package com.lxf.Optimize;

import java.math.BigDecimal;

/**
 * 陷阱题
 */
public class Optimize1 {
    public static void main(String[] args) {
        /*
        计算机无法精确表示0.1,只能精确表示0.75  0.5  0.125等，公式2的N次幂
         */
//        float a = 1.0f - 0.9f;
//        float b = 0.9f - 0.8f;
//        if (a == b) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");//false
//        }


//        Float a = Float.valueOf(1.0f - 0.9f);
//        Float b = Float.valueOf(0.9f - 0.8f);
//        if (a.equals(b)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");//false
//        }


        /*
        空指针异常:switch支持String,先比较hashCode(),再比较equals(),
        在hashCode()时就报空指针
         */
//        String param = null;
//        switch (param) {
//            case "null":
//                System.out.println("null");
//                break;
//            default:
//                System.out.println("default");
//        }


        /*
        计算机不能精确表示0.1
         */
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);//0.1000000000000000055511151231257827021181583404541015625
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);//0.1

    }
}
