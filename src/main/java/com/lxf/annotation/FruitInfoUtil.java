package com.lxf.annotation;

import java.lang.reflect.Field;

/**
 * @Description 注解处理器
 * @Author Administrator
 * @DATE 2019/4/15 16:58
 * @Version 1.0
 **/
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){
        String strFruitName = "水果名称：";
        String strFruitColor = "水果颜色：";

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println(strFruitName + fruitName.value());
            }

            if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println(strFruitColor + fruitColor.fruitColor().name());
            }
        }

    }
}
