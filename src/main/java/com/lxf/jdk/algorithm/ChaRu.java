package com.lxf.jdk.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 * 1、未排序元素依次同所有已排序元素比较，若比已排序元素大，则放到已排序元素右侧
 * 2、length-1轮。从第二个元素开始的
 * 3、每轮都比较当前元素和之前元素
 * 4、时间复杂度约n^2
 */
public class ChaRu {

    public static void main(String[] args) {
        int[] array = Base.array;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {//length-1轮
            int current = array[i + 1];
            int preIndex = i;
            while(preIndex >=0 && current < array[preIndex]){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(array));
    }
}
