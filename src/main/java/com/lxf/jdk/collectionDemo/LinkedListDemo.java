package com.lxf.jdk.collectionDemo;


import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        LinkedList<Object> list = new LinkedList<>();
        list.add(null);
        list.peek();
        list.poll();
        list.addFirst("HH");
        list.addLast("II");
        list.removeFirst();
        list.removeLast();
        list.add("aa");
        list.add("bb");
        System.out.println(list); // [aa, bb]
    }


}
