package com.lxf.jdk8.foundation.spi.dubbo;

import org.apache.dubbo.common.URL;

public class WechatOrder implements GoodsOrder{
    @Override
    public String getPayWay() {
        return "微信支付";
    }

    @Override
    public String payWay(URL url) {
        return "pay 微信支付";
    }
}
