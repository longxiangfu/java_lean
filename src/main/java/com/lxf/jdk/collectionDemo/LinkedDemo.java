package com.lxf.jdk.collectionDemo;


import java.lang.reflect.Array;
import java.util.LinkedList;

public class LinkedDemo {
    public static void main(String[] args) {
        /*
        测试ListItr中方法remove()中代码块
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
         */
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add(null);
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.offer("I");
        list.push("J");
//        ListIterator listIterator = list.listIterator(1);
//        String reuslt = listIterator.next().toString();
//        listIterator.remove();



        /*
         创建按一个确定类型和确定大小的数组
         */
        String[] intArr = new String[5];
        list.toArray(intArr);//测试 a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        Array.newInstance(intArr.getClass().getComponentType(), 20);


        //
        list.add(null);
        list.peek();
        list.poll();
        list.addFirst("HH");
        list.addLast("II");
        list.removeFirst();
        list.removeLast();

        //
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
