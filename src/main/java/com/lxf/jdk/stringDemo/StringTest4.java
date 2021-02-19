package com.lxf.jdk.stringDemo;

public class StringTest4 {

    public static void main(String[] args) {
        System.out.println("  s  s  ".trim());
        System.out.println("   ".trim());
    }

    public static boolean isEmpty( String str) {
        return (str == null || "".equals(str.trim()));
    }

}
