package com.lxf.jdk.jdk_E.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream的原理
 * 1、相关类：BaseStream\Stream\ReferencePipeline(内部类Head\StatelessOp\StatefulOp)\AbstractPipeline\PipelineHelper\Sink
 * 2、ReferencePipeline:管道，有三个内部类
 * Head:加载数据源操作
 * StatelessOp\StatefulOp:加载无状态、有状态的中间操作
 * 3、Sink:定义各个操作之间的关系，包括方法begin()\end()\cancellationRequested()\accept()
 * 4、中间操作不进行实际的执行，而是生成了对应操作的stage,进行终端操作时，终端stage触发之前的中间stage,生成一个Sink链，最终循环遍历
 * Slink链执行计算
 */
public class sourceDemo {
    public static void main(String[] args) {
//        List<String> names = Arrays.asList("张三", "李四", "王五");
//        names.stream()
//                .filter(name -> name.startsWith("张"))
//                .mapToInt(String::length)
//                .max()
//                .toString();



        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            integers.add(i);
        }
        //第一种方式  平行流会有线程安全问题，越界、重复、少元素的情况
        ArrayList<Integer> parallelList = new ArrayList<>();
        integers.stream()
                .parallel()
                .filter(i -> i%2==1)
                .forEach(i -> parallelList.add(i));
        System.out.println("hehehheh");
        //第二种方式
        List<Integer> list = integers.stream()
                .parallel()
                .filter(i -> i%2==1)
                .collect(Collectors.toList());
        System.out.println("husbfuusjopn");
    }
}
