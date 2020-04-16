package com.lxf.jdk8.foundation;

public class MathTest {

    public static void main(String[] args) {
        //在数轴上取值时，中间值（0.5）向右取整
        long round = Math.round(-1.5);
        System.out.println(round);//-1
    }
}
