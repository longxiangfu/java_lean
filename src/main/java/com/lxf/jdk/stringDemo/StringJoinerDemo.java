package com.lxf.jdk.stringDemo;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Description
 * 1、如果只是简单的字符串拼接，考虑直接使用"+"即可。
 * 2、如果是在for循环中进行字符串拼接，考虑使用StringBuilder和StringBuffer。
 * 3、如果是通过一个集合（如List）进行字符串拼接，则考虑使用StringJoiner。
 * 4、如果是对一组数据进行拼接，则可以考虑将其转换成Stream，并使用StringJoiner处理
 * @Author Administrator
 * @DATE 2019/2/28 11:46
 * @Version 1.0
 **/
public class StringJoinerDemo {
    public static void main(String[] args) {
//        basicOperate();
        testStream();
    }

    /**
     * 基本操作
     */
    private static void basicOperate(){
        StringJoiner sj = new StringJoiner("A");
        sj.add("B");
        sj.add("C");
        System.out.println(sj.toString());

        StringJoiner sj1 = new StringJoiner(":", "[", "]");
        sj1.add("A").add("B").add("C");
        System.out.println(sj1.toString());

        System.out.println("");
        System.out.println("123");
    }

    /**
     * 与流相关
     */
    private static void testStream(){
        List<String> list = ImmutableList.of("A", "B", "C");
////        List<String> list = new ArrayList<>();
//        //
//        StringBuilder sb = new StringBuilder();
//        if(!list.isEmpty()){
//            for(String str : list){
//                sb.append(",").append(str);
//            }
//        }
//        System.out.println(sb.toString());

//        String result = list.stream().reduce(new StringBuilder(), (sb1, s) -> sb1.append(s).append(','), StringBuilder::append).toString();
//        System.out.println(result);

//        String result = list.stream().reduce((a, b) -> a + "," + b).toString();
//        System.out.println(result);

        String result = list.stream().collect(Collectors.joining(":", "[", "]")).toString();
        System.out.println(result);

        String a = UUID.randomUUID().toString();
        String b = a.substring(0,17);
        System.out.println(b);

    }

}
