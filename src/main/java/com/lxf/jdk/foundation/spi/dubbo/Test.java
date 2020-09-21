package com.lxf.jdk.foundation.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 通过扩展类名称类加载扩展类
 */
public class Test {
    public static void main(String[] args) {
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        GoodsOrder aliPay = loader.getExtension("aliPay");
        System.out.println(aliPay.getPayWay());

        GoodsOrder wechatPay = loader.getExtension("wechatPay");
        System.out.println(wechatPay.getPayWay());

        //以下两种会报错，并不是获取@SPI("aliPay")中的默认扩展类。@SPI("aliPay")运用于自适应机制
//        System.out.println(loader.getExtension(null).getPayWay());
//        System.out.println(loader.getExtension("").getPayWay());
    }
}
