package com.lxf.jdk.foundation.spi.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = "online", order = 1)
public class WechatOrder implements GoodsOrder{
    @Override
    public String getPayWay() {
        return "微信支付";
    }

    @Override
    public String payWay(URL url) {
        System.out.println("pay 微信支付");
        return "pay 微信支付";
    }
}
