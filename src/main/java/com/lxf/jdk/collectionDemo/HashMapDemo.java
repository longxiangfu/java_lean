package com.lxf.jdk.collectionDemo;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class HashMapDemo {
    public static void main(String[] args) {
//        HashMap map = new LinkedHashMap();
//        /*
//        验证方法static final int tableSizeFor(int cap):返回大于n的最小的2的自然数幂
//         */
//        int n = 100 - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        System.out.println("n:" + n);
//
//        //测试
////        int a = 0;
////        int value = (int)map.get(1);
////        if ((a = value) == 1) {
//        //value是否赋值给了a
//        map.put(1, 1);
//        map.put(2, 2);
//        int a = 0;
//        int value = (int)map.get(1);
//        if ((a = value) == 1) {
//            System.out.println("map.get:" + map.get(1).toString());
//        }
//        System.out.println("a:" + a);
//
//
//        //
//        Set<Integer> keySet = map.keySet();
//        keySet.forEach(e -> System.out.println("key:" + e));
//
//        //
//        InputStream inputStream = new InputStream() {
//            @Override
//            public int read() throws IOException {//read是个阻塞操作
//                return 0;
//            }
//        };
//        try {
//            ObjectInputStream ois = new ObjectInputStream(inputStream);
//            ois.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        //aiXcoder
//        try {
//
//        }catch (Exception e){
//            System.out.println("1");
//        }
//
//        //
//        try {
//            assert 1==1;
//        }catch (Exception e){
//            log.error(e.getMessage(), e);
//        }
//        System.out.println("断言正确");
//
//
//        //
//        int h = 1, j = 2, k;
//        k = 10;
//
//
//        //
//        Integer age = 10;
//        long code = System.identityHashCode(age);
//        System.out.println("code:" + code);
//
//        //
//        HashMap<String, String> map1 = new HashMap();
//        map1.put(null, null);

    //HashMap允许空键值，Hashtable不允许
//        HashMap map = new HashMap();
//        map.put(null, null);
//        Hashtable table = new Hashtable();
//        table.put(null, null);//运行抛空指针(Hashtable的key和value都不能为null)

        //HashSet
//        HashSet hashSet = new HashSet();
//        hashSet.add("a");

        //CurrentHashMap
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put("1", 1);

        //LinkedHashMap
        //插入顺序(按插入顺序排序)
//        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap();
//        linkedHashMap.put("1", 1);
//        linkedHashMap.put("2", 2);
//        linkedHashMap.put("3", 3);
//        Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
//        Iterator iterator =entries .iterator();
//        System.out.println("LinkedList插入顺序");
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> entry = (Map.Entry)iterator.next();
//            System.out.println(String.format("key:%s, value:%d", entry.getKey(), entry.getValue()));
//        }
        //访问顺序（按访问顺序进行排序，即将最近访问的node放到最后）
//        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap(16, 0.75f, true);
//        linkedHashMap1.put("4", 4);
//        linkedHashMap1.put("5", 5);
//        linkedHashMap1.put("6", 6);
//        linkedHashMap1.get("4");
//        Set<Map.Entry<String, Integer>> entries1 = linkedHashMap1.entrySet();
//        Iterator iterator1 =entries1 .iterator();
//        System.out.println("LinkedList访问顺序");
//        while (iterator1.hasNext()) {
//            Map.Entry<String, Integer> entry1 = (Map.Entry)iterator1.next();
//            System.out.println(String.format("key:%s, value:%d", entry1.getKey(), entry1.getValue()));
//        }
//        //result:
//        LinkedList访问顺序
//        key:5, value:5
//        key:6, value:6
//        key:4, value:4

        //map输出格式
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        System.out.println(map.toString());//{1=a, 2=b, 3=c, 4=d, 5=e}



    }



}
