package com.lxf.annotation.AnnotationValue;

import java.lang.reflect.Field;

/**
 * 属性上注解测试
 */
public class FieldAnnotationTest {

    @Banana
    private Integer id;

    public static void main(String[] args) {
        Class<FieldAnnotationTest> aClass = FieldAnnotationTest.class;
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean annotationPresent = declaredField.isAnnotationPresent(Banana.class);
            if (annotationPresent) {
                Banana annotation = declaredField.getAnnotation(Banana.class);
                System.out.println("注解第一个参数：" + annotation.name() + "。注解第二个参数：" + annotation.value());
            }
        }

    }
}
