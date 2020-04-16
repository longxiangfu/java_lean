package com.lxf.exception;

/**
 * @Description  捕获异常后不抛出，可继续执行下面的代码
 * @Author Administrator
 * @DATE 2019/4/29 10:47
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {//throws Exception
        for (int i = 0; i<10; i++){
            try{
                throw new Exception("参数为空");
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("可执行");
        }


//        throw new Exception();

    }
}
