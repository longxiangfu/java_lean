package com.lxf.jdk8.time;

import java.time.LocalTime;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/26 13:29
 * @Version 1.0
 **/
public class LocalTimeDemo {
    public static void main(String[] args) {
        //获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //构建时间
        LocalTime localTime1 = LocalTime.of(12, 15, 30);
        //获取当前时间，不包含毫秒数
        LocalTime localTime2 = localTime.withNano(0);
        //字符串转时间
        LocalTime localTime3 = LocalTime.parse("12:15:30");
        System.out.println(localTime + "|" + localTime1 + "|" + localTime2 + "|" + localTime3);

    }
}
