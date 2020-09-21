package com.lxf.jdk.foundation.spi.dubbo.activate;

import com.lxf.jdk.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"online", "offline"}, order = 3)
public class CardOrder implements GoodsOrder{
    @Override
    public String getPayWay() {
        return "银联卡支付";
    }

    @Override
    public String payWay(URL url) {
        System.out.println("银联卡支付");
        return "银联卡支付";
    }
}
