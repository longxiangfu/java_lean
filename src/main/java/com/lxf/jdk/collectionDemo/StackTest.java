package com.lxf.jdk.collectionDemo;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }
        //c b a
    }
}
