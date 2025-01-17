package com.lxf.jdk.collectionDemo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class HashMapDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        verifyExpansion();
//        myHashCode(10);
//        permitNull();
        viewFormat();



    }

    private static void viewFormat() {
        //map输出格式
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        System.out.println(map); // {1=a, 2=b, 3=c, 4=d, 5=e}

    }

    /**
     * 验证HashMap和HashTable的key和value是否允许为null
     */
    private static void permitNull() {
        // map的key和value都允许为null
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put("1", null);
        map.put(null, "1");

        // Hashtable的key和value都不允许为null
        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put(null, null);
//        hashtable.put(null, "1");
//        hashtable.put("1", null);
    }

    /**
     * 获取hashCode
     * @param object
     * @return
     */
    public static int myHashCode(Object object) {
        int hash = System.identityHashCode(object);
        System.out.println("hash:" + hash); // hash:715521683
        return hash;
    }


    /**
     * 验证扩容机制
     */
    public static void verifyExpansion() throws NoSuchFieldException, IllegalAccessException {
        // 创建初始容量为4，负载因子为0.75的HashMap,那么负载容量为4*0.75=3
        HashMap<Integer, String> map = new HashMap<>(4, 0.75f);

        // 插入5个元素，触发扩容
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println("容量：" + getCapacity(map)); // 容量：4
        System.out.println("元素个数：" + map.size()); // 元素个数：3
        System.out.println("---------");
        map.put(4, "four"); // 先放元素，再检查扩容  当前元素的数量4>负载容量3
        System.out.println("容量：" + getCapacity(map)); // 容量：8
        System.out.println("元素个数：" + map.size()); // 元素个数：4
        System.out.println("---------");
        map.put(5, "five");
        System.out.println("容量：" + getCapacity(map)); // 容量：8
        System.out.println("元素个数：" + map.size()); // 元素个数：5
        System.out.println("---------");

    }

    /**
     * 获取map中数组的容量
     * @param map
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static int getCapacity(HashMap map) throws NoSuchFieldException, IllegalAccessException {
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map);
        return table.length; // 表示数组的容量，而不是数组中元素的个数
    }



}
