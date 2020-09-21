package com.lxf.jdk.foundation;

public class Test {
    public static void main(String[] args) {
        //"=="和equals的区别
        //"=="对于基本类型，比较值，对于引用类型，比较地址
        //equals:比较的是地址，但是String\Integer等重写了equals方法，变成的值比较
        test();

    }

    /**
     * "=="和equals的区别
     */
    private static void test() {
//        String
//        Integer
//        Long
//        Float
//        Double
//        Boolean
//        Byte
//        Character//equals时地址相等
//        Short
    }

    /**
     * 测试String的equal方法，模拟equal方法
     * @return
     */
    private static boolean stringEqual() {
        String a = "aaaaa";
        char[] aRray = a.toCharArray();
        String b = "aaaab";
        char[] bRray = b.toCharArray();
        int n = aRray.length;
        if (bRray.length == n) {
            int i = 0;
            while (n != 0){
                if (aRray[i] != bRray[i]) {
                    return false;
                }
                i++;
            }
        }
        return false;
    }
}
