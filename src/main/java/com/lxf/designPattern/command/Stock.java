package com.lxf.designPattern.command;

import lombok.Data;

/**
 * 请求类
 */
@Data
public class Stock {
    private Integer type = 0;
    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity + "type" + type + " ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity + "type" + type + " ] sold");
    }
}
