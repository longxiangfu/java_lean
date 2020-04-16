package com.lxf.jdk8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/26 13:35
 * @Version 1.0
 **/
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //获取当前年月日时分秒
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.plus(100, ChronoUnit.DAYS));
        //通过LocalDate和LocalTime构建
        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(localDateTime1);
        //构建
        LocalDateTime localDateTime12 = LocalDateTime.of(2019, 01, 21, 19, 33, 33);
        System.out.println(localDateTime12);
        //格式化当前时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(formatter.format(localDateTime12));

        Year yaer = Year.now();
        System.out.println(yaer);
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);

    }
}
