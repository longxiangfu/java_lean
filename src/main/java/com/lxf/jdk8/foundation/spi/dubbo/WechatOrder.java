package com.lxf.jdk8.foundation.spi.dubbo;

public class WechatOrder implements Order{
    @Override
    public String getPayWay() {
        return "微信支付";
    }
}
