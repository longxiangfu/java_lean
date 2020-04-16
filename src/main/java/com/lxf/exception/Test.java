package com.lxf.exception;

public class Test {
    public static void main(String[] args) {
        //multiple catch
//        try{
//            FileReader reader = new FileReader("");
//        }catch(IOException | NullPointerException e){
//            //业务处理
//        }

        //以下代码违反了两个原则：1、不用捕捉通用异常Exception，要捕获特定异常像NumberFormatException  2、捕获异常后，必须进行处理
//        try {
//            int anInt = Integer.parseInt("10");
//        }catch (Exception e){
//
//        }

        //try-catch-finanlly中可以省略catch
        //运行时异常捕捉：不使用任何代码，程序自动捕捉；try-finanlly    非运行时异常：必须用try-catch-finanlly或try-catch
//        try {
//
//        } finally {
//
//        }

        //结果try
//        try {
//            System.out.println("try");
//        }catch (Exception e){
//            System.out.println("catch");
//        }finally {
//            int i = 10/0;
//            System.out.println("finanlly");
//        }
//        System.out.println("end");

        //都会抛出NumberFormatException
//        Integer.parseInt(null);
//        Double.parseDouble(null);

        //NoClassDefFoundError和ClassNotFoundException的区别
//        NoClassDefFoundError
//        ClassNotFoundException
//        try {
//            Class.forName("");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        //类加载器加载不到类，抛出NoClassDefoundError

        //捕获ArithmeticException属于运行时异常，可以用try捕捉
//        try {
//            int i = 10 / 0;
//        } finally {
//            System.out.println("last");
//        }

        //System.exit()之后，不会执行finanlly中的代码
        //System.exit():中断虚拟机的运行
        try {
            System.exit(1);
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finanlly");
        }



    }

}
