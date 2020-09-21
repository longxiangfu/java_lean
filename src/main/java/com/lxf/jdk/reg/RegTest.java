package com.lxf.jdk.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式3种模式：贪婪模式、懒惰模式、独占模式
 */
public class RegTest {
    private static Pattern pattern = Pattern.compile("ab{1,3}c");//贪婪模式
    private static Pattern pattern1 = Pattern.compile("ab{1,3}?c");//懒惰模式
    private static Pattern pattern2 = Pattern.compile("ab{1,3}+bc");//独占模式

    public static void main(String[] args) {
        String test = "abbcde";
        String test1 = "abbc";
        String test2 = "abbc";

        Matcher matcher = pattern.matcher(test);
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.matches());//true
            System.out.println("------------");
        }

        Matcher matcher1 = pattern1.matcher(test1);
        while (matcher1.find()){
            System.out.println(matcher1.group());
            System.out.println(matcher1.matches());//true
            System.out.println("------------");
        }



        Matcher matcher2 = pattern2.matcher(test2);
        while (matcher2.find()){
            System.out.println(matcher2.group());
            System.out.println("------------");
        }
        System.out.println(matcher2.matches());//false






    }
}
