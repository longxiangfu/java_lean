package com.lxf.jdk8.foundation.spi.dubbo;

public class AliPayOrder implements Order{
    @Override
    public String getPayWay() {
        return "支付宝支付";
    }
}
