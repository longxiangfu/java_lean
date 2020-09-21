package com.lxf.jdk.collectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sublist演示：ArrayList.subList()返回SubList,是一个List,是ArrayList的内部类，是ArrayList的视图，父List和子List都指向
 * 同一个内存地址
 * 不能将SubList强转成ArrayList
 */
public class subListTest {
    public static void main(String[] args) {
        /*
        1.非结构性改变SubList:父List和子List都会改变
         */
//        List<String> sourceList = new ArrayList();
//        sourceList.add("H");
//        sourceList.add("O");
//        sourceList.add("L");
//        sourceList.add("L");
//        sourceList.add("I");
//        sourceList.add("S");
//
//        List subList = sourceList.subList(2, 5);
//
//        System.out.println("sourceList:" + sourceList);
//        System.out.println("sourceList.subList(2, 5)得到List：" + subList);
//
//        subList.set(1, "666");
//
//        System.out.println("sourceList:" + sourceList);
//        System.out.println("subList.set(1, \"666\")得到List：" + subList);

        /*
        2.非结构性改变父List:父List和子List都会改变
         */
        /*
        3.非结构性改变子List:父List和子List都会改变
         */

        /*
        4.非结构性改变父List:会抛出异常CME(CurrentModificationException:并发修改)
        CME:由于fail-fast机制(快速失败：预先检查)导致的
        */
//        List<String> sourceList = new ArrayList<String>() {{
//            add("H");
//            add("O");
//            add("L");
//            add("L");
//            add("I");
//            add("S");
//        }};
//
//        List subList = sourceList.subList(2, 5);
//
//        System.out.println("sourceList ： " + sourceList);
//        System.out.println("sourceList.subList(2, 5) 得到List ：");
//        System.out.println("subList ： " + subList);
//
//        sourceList.add("666");
//
//        System.out.println("sourceList.add(666) 得到List ：");
//        System.out.println("sourceList ： " + sourceList);
//        System.out.println("subList ： " + subList);






        List<String> list = Arrays.asList("1", "2");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(10);
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println("下标/值:"+i + "/" + list1.get(i));
//
//        }

        String[] arr = new String[10];
        arr[0] = "1";
        arr[1] = "2";
        arr[2] = "3";

        //测试removeAll
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(6);
        list3.add(7);
        list2.removeAll(list3);


    }
}
