package com.lxf.jdk.jdk_E.stream.reduce;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Description reduce操作
 * @Author Administrator
 * @DATE 2019/4/16 14:30
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        //求和
//        Integer sum = stream.reduce(0, Integer::sum);
        //求和
//        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);
        //求最大值
//        stream.reduce(Integer::max).ifPresent(System.out::println);
        //求最小值
//        stream.reduce(Integer::min).ifPresent(System.out::println);
        //做逻辑
//        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);
        //求逻辑求乘积
        Optional.ofNullable(stream.filter(i -> i % 2 == 0).reduce((i, j) -> i * j)).ifPresent(System.out::println);


//        System.out.println(sum);

    }
}
