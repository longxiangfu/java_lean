package com.lxf.jdk8.collectionDemo;

import jodd.util.collection.ArrayEnumeration;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        //线程安全
        Vector vector = new Vector();
        vector.add("a");

        Hashtable hashtable = new Hashtable();
        hashtable.put("a", "aaa");

        Stack stack = new Stack();
        stack.push("aaa");

        String[] strArray = new String[10];
        strArray[0] = "a";
        Enumeration<String> enumeration = new ArrayEnumeration(strArray);
        if (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();
        }


    }
}
