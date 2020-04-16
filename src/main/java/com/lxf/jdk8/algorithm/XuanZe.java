package com.lxf.jdk8.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 * 1、第一轮，在未排序序列中查找最小值,并将最小值和array[0]交换；第二轮，在未排序序列中查找最小值，并将最小值和array[1]交换...
 * 2、length-1轮。每一轮找到一个小值，需要length-1轮查找
 * 3、每一轮从array[i]开始比较。
 * 4、时间复杂度大约n^2
 */
public class XuanZe {

    public static void main(String[] args) {
        int[] array = Base.array;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {//循环length-1轮
            int minIndex = i;
            for (int j = i; j < length; j++) {//循环未排序的序列
                if(array[j] < array[minIndex]){
                    minIndex = j;//找到最小值的标号
                }
            }
            //将最小值和array[i]交换
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));

    }
}
