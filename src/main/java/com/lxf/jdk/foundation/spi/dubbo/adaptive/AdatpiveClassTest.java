package com.lxf.jdk.foundation.spi.dubbo.adaptive;

import com.lxf.jdk.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 通过自适应扩展类的方式加载扩展类
 */
public class AdatpiveClassTest {
    public static void main(String[] args) {
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        //获取自适应扩展类，并且未指定扩展类名称
        GoodsOrder GoodsOrder = loader.getAdaptiveExtension();
        System.out.println(GoodsOrder.getPayWay());

        //获取自适应扩展类，并且指定扩展类名称
        ((AdaptiveGoodsOrder)GoodsOrder).setExtentionName("wechatPay");
        System.out.println(GoodsOrder.getPayWay());

    }
}
