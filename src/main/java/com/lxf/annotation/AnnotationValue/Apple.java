package com.lxf.annotation.AnnotationValue;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Apple {

    String name() default "longxiangfu";

    String value() default "chenting";
}
