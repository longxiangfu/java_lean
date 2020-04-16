package com.lxf.jdk8.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/26 13:51
 * @Version 1.0
 **/
public class TemporalAdjustersDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
    }
}
