package com.lxf.jdk8.collectionDemo;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        //数组初始化
        int[] arr = new int[5];//默认元素都是0
        int[] arr2 = new int[]{1, 2, 3, 4};
        int[] arr3 = {1, 2, 3};
        Arrays.stream(arr).forEach(value -> System.out.println(value));
        System.out.println(Arrays.toString(arr));

        //数组复制
//        int[] arr2Copy = Arrays.copyOf(arr2, arr2.length);
//        System.out.println(Arrays.toString(arr2Copy));

        //数组填充
//        int[] arrFill = new int[5];
//        Arrays.fill(arrFill, 10);
//        System.out.println(Arrays.toString(arrFill));//[6, 6, 6, 6, 6, 6]

        //数组合并
//        int[] arr4 = ArrayUtils.addAll(arr2, arr3);
//        System.out.println(Arrays.toString(arr4));//[1, 2, 3, 4, 1, 2, 3]

        //数组排序
//        Arrays.sort(arr2);

        //数组逆序（不是到排序）
//        ArrayUtils.reverse(arr2);
//        System.out.println(Arrays.toString(arr2));//[4, 3, 2, 1]

        //二分法查找（需要先排序）
//        Arrays.sort(arr2);
//        int index = Arrays.binarySearch(arr2, 3);
//        System.out.println(index);//2

        //二维数组
//        int[][] twoArr = new int[2][4];//2行4列  申明并初始化
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 4; j++) {
//                twoArr[i][j] = j;
//            }
//        }
//        System.out.println(twoArr[0][1]);//1
//        System.out.println(Arrays.toString(twoArr[0]));//[0, 1, 2, 3]
//        System.out.println(Arrays.toString(twoArr[1]));//[0, 1, 2, 3]

        //数组类型转换
//        //String->Array
//        String str = "a,b,c,d";
//        String[] split = str.split(",");
//        System.out.println(Arrays.toString(split));//[a, b, c, d]
//        //Array->String
//        String[] stringArr = new String[]{"a", "b", "c", "d"};
//        System.out.println(Arrays.toString(stringArr));//[a, b, c, d]
//        //List->Array
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(Arrays.toString(list.toArray()));//[1, 2]
//        //Array->List
//        System.out.println(Arrays.asList(stringArr));//[a, b, c, d]

        //集合同时存储不同类型的数据；数组只能同时存储同一种数据类型
//        List<Object> list = new ArrayList<>();
//        list.add(1);
//        list.add("a");
//        list.add(true);

        //
//        String[] strArray = new String[3];
//        System.out.println(Arrays.toString(strArray));//[null, null, null]

        //
//        String[] strArr = {"dog", "cat", "pig", "bird"};
//        String[] strArr2 = {"dog", "cat", "pig", "bird"};
//        System.out.println(strArr == strArr2);//false
//        System.out.println(strArr.equals(strArr2));//false
//        System.out.println(Arrays.equals(strArr, strArr2));//true(重写了equal方法)

        //使用二分法查找之前需要排序
//        String[] arrArray = {"dog", "cat", "pig", "bird"};
////        Arrays.sort(arrArray);
//        int result = Arrays.binarySearch(arrArray, "bird");
//        System.out.println(result == -1);//true

        //数组中是否包含某值
//        String[] array = new String[]{"a", "b", "c"};
//        Arrays.sort(array);
//        System.out.println(Arrays.binarySearch(array, "d") > -1);
//        System.out.println(Arrays.asList(array).contains("d"));

        //修改数组中指定区间中元素值(将第二个到第三个数修改为10)
        int[] array = new int[]{1, 2, 3, 4, 5};
        Arrays.fill(array, 1, 3, 10);
        System.out.println(Arrays.toString(array));

    }
}
