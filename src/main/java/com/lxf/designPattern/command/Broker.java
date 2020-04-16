package com.lxf.designPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令调用类
 */
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    /**
     * 将命令放到集合中
     * @param order
     */
    public void takeOrder(Order order){
        orderList.add(order);
    }

    /**
     * 调用命令
     */
    public void invokeOrder(Stock stock){
        for (Order order:orderList
             ) {
            if(order.support(stock)){
                order.execute();
                orderList.clear();
                return;
            }
        }
    }





}
