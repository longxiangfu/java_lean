package com.lxf.jdk8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        //获取当前时间
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);//2020-02-24
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);//17:56:29.479
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2020-02-24T17:56:29.479

        //获取时间戳
        long epochMilli = Instant.now().toEpochMilli();
        System.out.println(epochMilli);//精确到毫秒 1582538189479
        long epochSecond = Instant.now().getEpochSecond();
        System.out.println(epochSecond);//精确到秒 1582538189

        //时间格式化
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(format);//2020-02-24 18:00

        //时间转换
        String str = "2019-02-24 17:37:00";
        LocalDateTime parse = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);//2019-02-24T17:37

        //获取昨天此刻
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = now.minusDays(1);
        System.out.println(before);//2020-02-23T18:00:33.257

        //比较两个时间大小
        LocalDateTime atime = LocalDateTime.now();
        LocalDateTime btime = atime.plusDays(1);
        int value = atime.compareTo(btime);
        if (value == -1) {
            System.out.println(atime + "<" + btime);
        }else if(value == 0){
            System.out.println(atime + "=" + btime);
        }else {
            System.out.println(atime + ">" + btime);
        }

    }
}
