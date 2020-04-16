package com.lxf.annotation;

import lombok.Data;

/**
 * @Description 注解使用
 * @Author Administrator
 * @DATE 2019/4/15 17:07
 * @Version 1.0
 **/
@Data
public class Apple {
    @FruitName(value = "红元帅")
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    private String appleColor;
}
