package com.lxf.idea;

/**
 * debug增强预处理
 */
public class DebugStrong {
    public static void main(String[] args) {
        int a = 0;
        while (a < 100) {//a=0时，此处显示true
            if (a == 3) {//a=0时，此处显示false
                System.out.println("+++++");
            }
            a++;
        }
    }
}
