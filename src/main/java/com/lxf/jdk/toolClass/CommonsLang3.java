package com.lxf.jdk.toolClass;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * commons-langs类库
 */
public class CommonsLang3 {

    public static void main(String[] args) {
        // 字符串判空
//        String str = "";
//        StringUtils.isEmpty(str);
//        StringUtils.isNotEmpty(str);
//        StringUtils.isBlank(str);
//        StringUtils.isNotBlank(str);


        // 首字母转大写
//        String str = "longxiangfu";
//        String capitalize = StringUtils.capitalize(str);
//        System.out.println("首字母转大写：" + capitalize);
//        String lowerCase = StringUtils.lowerCase(capitalize);
//        System.out.println("首字母转小写：" + lowerCase);

        // 重复拼接字符串
//        String repeat = StringUtils.repeat("ab", 3);
//        System.out.println("重复拼接字符串：" + repeat); // 重复拼接字符串：ababab

        /*
         格式化日期
          */
//        // Date转String
//        String format = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
//        System.out.println("Date转String:" + format); // Date转String:2021-08-13 15:11:32
//        // String转Date
//        try {
//            Date date = DateUtils.parseDate(format,"yyyy-MM-dd HH:mm:ss");
//            System.out.println("String转Date:" + date); // String转Date:Fri Aug 13 15:11:32 CST 2021
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        // 计算一个小时候的日期
//        Date date = DateUtils.addHours(new Date(), 1);
//        System.out.println("计算一个小时候的日期:" + date); // 计算一个小时候的日期:Fri Aug 13 16:12:47 CST 2021

        // 包装临时对象
//        ImmutablePair<Integer, String> pair = ImmutablePair.of(1, "longxiangfu");
//        System.out.println(pair.getLeft() + "," + pair.getRight()); // 1,longxiangfu
//        ImmutableTriple<Integer, String, Date> triple = ImmutableTriple.of(1, "lognxiangfu", new Date());
//        System.out.println(triple.getLeft() + "," + triple.getMiddle() + "," + triple.getRight()); // 1,lognxiangfu,Fri Aug 13 15:46:57 CST 2021




    }
}
