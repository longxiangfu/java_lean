package com.lxf.jdk.foundation.abstractAndInterfaceTest.mianshi6;

public class Test {
    public void test(IPlant iPlant){
    }

    public static void main(String[] args) {
        IPlant<Integer, Integer> iPlant = from -> from + 10;
        System.out.println(iPlant.sleep(5));
    }
}
