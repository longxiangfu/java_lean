package com.lxf.jdk.calculateAndCycle;


public class DoublePlusTest {
    public static void main(String[] args) {
        //i++和++i的区别
//        int i = 0;
//        int i2 = i++;
//        int j = 0;
//        int j2 = ++j;
//        System.out.println(i2);//0
//        System.out.println(j2);//1

        //
//        int i = 0;
//        i = i++;
//        System.out.println(i);//0
//        int j = 0;
//        int k = j++;
//        System.out.println(k);//0
//        System.out.println(j);//1

        //结果：123default
//        int num = 1;
//        switch (num) {
//            case 0:
//                System.out.print("0");
//            case 1:
//                System.out.print("1");
//            case 2:
//                System.out.print("2");
//            case 3:
//                System.out.print("3");
//            default:
//                System.out.print("default");
//        }

        //do/while后面加; ,否则编译器报凑
//        int i = 0;
//        do{
//            System.out.println(++i);
//        } while (i < 3);

        //
        String s = new String("laowang");
        String s2 = new String("laowang");
        System.out.println(s == s2);
        switch (s){
            case "laowang"://用equals比较
                System.out.println("laowang");
                break;
            default:
                System.out.println("default");
        }


    }
}
