package com.lxf.jdk8.foundation.spi.dubbo.activate;

import com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;

/**
 * goup和value组成了该扩展类的唯一标识，因此在获取激活扩展类时，第二个参数和第三个参数都必须指定,才能获取该扩展类
 */
@Activate(group = "offline", order = 5, value = "coupon")
public class CouponOrder implements GoodsOrder{
    @Override
    public String getPayWay() {
        return "优惠券支付";
    }

    @Override
    public String payWay(URL url) {
        System.out.println("优惠券支付");
        return "优惠券支付";
    }
}
