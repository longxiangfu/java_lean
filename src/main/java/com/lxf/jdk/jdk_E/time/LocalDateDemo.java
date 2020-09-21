package com.lxf.jdk.jdk_E.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/26 11:41
 * @Version 1.0
 **/
public class LocalDateDemo {
    public static void main(String[] args) {
        //获取当前年月日    2019-04-26
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //构建年月日   2018-01-30
        LocalDate localDate1 = LocalDate.of(2018, 01, 30);
        System.out.println(localDate1);
        //字符串转换日期    2018-01-30
        LocalDate localDate2 = LocalDate.parse("2018-01-30");
        System.out.println(localDate2);
        //获取本月第一天     2019-04-01
        LocalDate firstDayIfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayIfMonth);
        //获取本月第二天     2019-04-02
        LocalDate secondDayOfMonth = localDate.withDayOfMonth(2);
        System.out.println(secondDayOfMonth);
        //获取本月最后一天    2019-04-30
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);
        //获取明天
        LocalDate tommrrowDay = localDate.plusDays(1);
        System.out.println(tommrrowDay);
        //获取昨天
        LocalDate yesterday = localDate.minusDays(1);
        System.out.println(yesterday);
        //获取本年第12天
        LocalDate day = localDate.withDayOfYear(12);
        System.out.println(day);
        //计算两日期之间的天数
        long days = localDate.until(localDate1, ChronoUnit.DAYS);
        System.out.println(days);
        //计算两日期之间的周数
        long weeks = localDate.until(localDate1, ChronoUnit.WEEKS);
        System.out.println(weeks);

    }
}
