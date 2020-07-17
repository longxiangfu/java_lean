package com.lxf.annotation.AnnotationValue;

import java.lang.reflect.Method;

/**
 * 测试方法上注解
 */
public class MethodAnnotationTest {

    public static void main(String[] args) {
        Class<MethodAnnotationTest> aClass = MethodAnnotationTest.class;
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            boolean annotationPresent = declaredMethod.isAnnotationPresent(Apple.class);
            if (annotationPresent) {
                Apple annotation = declaredMethod.getAnnotation(Apple.class);
                System.out.println("注解第一个参数：" + annotation.name() + "。注解第二个参数：" + annotation.value());
            }
        }

    }


    @Apple
    public void test(){

    }
}
