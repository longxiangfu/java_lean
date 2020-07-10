package com.lxf.fanshe.FanXing;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException {
        Method[] methods = Test.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getGenericReturnType());
        }

//        Method testReturn = Test.class.getMethod("testReturn", null);
//        Type returnType1 = testReturn.getGenericReturnType();
//        System.out.println("returnType1:" + returnType1);
//
//        Method method = Test.class.getDeclaredMethod("testReturn", null);
//        Type returnType = method.getGenericReturnType();
//        if(returnType instanceof ParameterizedType){
//            System.out.println(returnType);
//            Type[] actualTypeArguments = ((ParameterizedType) returnType).getActualTypeArguments();
//            for (Type actualTypeArgument : actualTypeArguments) {
//                System.out.println("泛型类型：" + actualTypeArgument);
//            }
//
//        }

    }


    public ResponseDTO<FanXingDo> testReturn(){
        return null;
    }
}
