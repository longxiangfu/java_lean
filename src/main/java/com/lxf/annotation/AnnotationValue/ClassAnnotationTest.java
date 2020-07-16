package com.lxf.annotation.AnnotationValue;

/**
 * 类上注解测试
 */
@Orange(name = "123", value = "456")
public class ClassAnnotationTest {

    public static void main(String[] args) {
        Class<ClassAnnotationTest> aClass = ClassAnnotationTest.class;
        boolean annotationPresent = aClass.isAnnotationPresent(Orange.class);
        if (annotationPresent) {
            Orange annotation = aClass.getAnnotation(Orange.class);
            System.out.println("注解第一个参数：" + annotation.name() + "。注解第二个参数：" + annotation.value());
        }
    }
}
