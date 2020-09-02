package com.lxf.jdk8.foundation.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 通过扩展类名称类加载扩展类
 */
public class Test {
    public static void main(String[] args) {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        Order aliPay = loader.getExtension("aliPay");
        System.out.println(aliPay.getPayWay());

        Order wechatPay = loader.getExtension("wechatPay");
        System.out.println(wechatPay.getPayWay());

        //以下两种会报错，并不是获取@SPI("aliPay")中的默认扩展类。@SPI("aliPay")运用于自适应机制
//        System.out.println(loader.getExtension(null).getPayWay());
//        System.out.println(loader.getExtension("").getPayWay());
    }
}
