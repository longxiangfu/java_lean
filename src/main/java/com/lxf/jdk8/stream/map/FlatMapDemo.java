package com.lxf.jdk8.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/22 16:09
 * @Version 1.0
 **/
public class FlatMapDemo {
    public static void main(String[] args) {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3),Arrays.asList(4, 5));
        stream.flatMap(
                (Function<List<Integer>, Stream<Integer>>) integers -> integers.stream()
        ).forEach(System.out::println);
    }
}
