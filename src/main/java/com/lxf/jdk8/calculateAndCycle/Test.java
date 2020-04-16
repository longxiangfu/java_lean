package com.lxf.jdk8.calculateAndCycle;

public class Test {
    public static void main(String[] args) {
        //0.1无法用二进制准确表示，所以会无线循环下去
        //可以用1/2^n之和表示的小数，可以用二进制准确表示，例如：0.5\0.75\0.875
        int count = 0;
        for (float i = 0; i != 0.6; i += 0.1) {
            count++;
            System.out.println(i);
            if (count == 20) {
                return;
            }
        }



    }

}
