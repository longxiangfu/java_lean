package com.lxf.jdk8.foundation.spi.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = "online", order = 1)
public class AliPayOrder implements GoodsOrder{
    @Override
    public String getPayWay() {
        return "支付宝支付";
    }

    @Override
    public String payWay(URL url) {
        System.out.println("pay 支付宝支付");
        return "pay 支付宝支付";
    }
}
