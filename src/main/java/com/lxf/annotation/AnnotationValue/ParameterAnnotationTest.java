package com.lxf.annotation.AnnotationValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 测试方法参数注解
 */
public class ParameterAnnotationTest {

    public static void main(String[] args) {
        Class<ParameterAnnotationTest> parameterAnnotationTestClass = ParameterAnnotationTest.class;
        Method[] declaredMethods = parameterAnnotationTestClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[][] parameterAnnotations = declaredMethod.getParameterAnnotations();
            if (parameterAnnotations == null || parameterAnnotations.length == 0) {
                return;
            }
            for (Annotation[] parameterAnnotation : parameterAnnotations) {
                for (Annotation annotation : parameterAnnotation) {
                    if (annotation instanceof Cherry){
                        Cherry cherry = (Cherry)annotation;
                        System.out.println("注解第一个参数：" + cherry.name() + "。注解第二个参数：" + cherry.value());
                    }
                }

            }
        }
    }


    public void test(@Cherry String name){

    }
}
