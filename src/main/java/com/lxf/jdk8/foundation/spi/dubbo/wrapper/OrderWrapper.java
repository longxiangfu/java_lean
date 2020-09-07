package com.lxf.jdk8.foundation.spi.dubbo.wrapper;


import com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.URL;

public class OrderWrapper implements GoodsOrder {

    private GoodsOrder goodsOrder;

    public OrderWrapper(GoodsOrder goodsOrder) {
        this.goodsOrder = goodsOrder;
    }

    @Override
    public String getPayWay() {
        String payWay = goodsOrder.getPayWay();
        return payWay;
    }

    @Override
    public String payWay(URL url) {
        System.out.println("前置增强");
        String payWay = goodsOrder.payWay(url);
        System.out.println("后置增强");
        return payWay;
    }
}
