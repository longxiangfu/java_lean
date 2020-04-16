package com.lxf.jdk8.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序：https://www.cnblogs.com/guoyaohua/p/8600214.html
 * 1、两两元素比较，前一个元素>或一个元素时，交换这两个元素
 * 2、循环length-1轮。每循环一轮，找到一个大值，总共n个元素，需要length-1轮即可
 * 3、每一轮比较次数为length-1-i。
 * 4、时间复杂度（n-1）*（n-1-i） ~  n^2
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] array = Base.array;
        int length = Base.array.length;
        for (int i = 0; i < length - 1; i++) {//循环length-1轮
            for (int j = 0; j < length - 1 - i; j++) {//每一轮比较次数length-1-i
                int arrayj = array[j];
                int arrayj1 = array[j + 1];
                if (arrayj > arrayj1){
                    //交换
                    array[j] = arrayj1;
                    array[j + 1] = arrayj;
                }

            }
        }
        System.out.println(Arrays.toString(array));
    }

}
