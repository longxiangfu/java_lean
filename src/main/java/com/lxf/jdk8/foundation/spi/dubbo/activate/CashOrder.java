package com.lxf.jdk8.foundation.spi.dubbo.activate;

import com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = "offline", order = 4)
public class CashOrder implements GoodsOrder{
    @Override
    public String getPayWay() {
        return "现金支付";
    }

    @Override
    public String payWay(URL url) {
        System.out.println("现金支付");
        return "现金支付";
    }
}
