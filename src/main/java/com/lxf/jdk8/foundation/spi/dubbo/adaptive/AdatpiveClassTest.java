package com.lxf.jdk8.foundation.spi.dubbo.adaptive;

import com.lxf.jdk8.foundation.spi.dubbo.Order;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 通过自适应扩展类的方式加载扩展类
 */
public class AdatpiveClassTest {
    public static void main(String[] args) {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        //获取自适应扩展类，并且未指定扩展类名称
        Order order = loader.getAdaptiveExtension();
        System.out.println(order.getPayWay());

        //获取自适应扩展类，并且指定扩展类名称
        ((AdaptiveOrder)order).setExtentionName("wechatPay");
        System.out.println(order.getPayWay());

    }
}
