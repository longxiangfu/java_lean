package com.lxf.jdk8.foundation.spi.dubbo;

import org.apache.dubbo.common.URL;

public class AliPayOrder implements GoodsOrder{
    @Override
    public String getPayWay() {
        return "支付宝支付";
    }

    @Override
    public String payWay(URL url) {
        return "pay 支付宝支付";
    }
}
