package com.lxf.jdk.other.holder;

/**
 * 无Holder时
 */
public class noHolderTest {
    public static void main(String[] args) {
        String name = "aaaa";
        changeName(name);
        System.out.println("old:" + name);
    }

    private static void changeName(String name) {//不可变对象是值传递
        name = "bbbb";
        System.out.println("new:" + name);
    }


//    new:bbbb
//    old:aaaa
}
