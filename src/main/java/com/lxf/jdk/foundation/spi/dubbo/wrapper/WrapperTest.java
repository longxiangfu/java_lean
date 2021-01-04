package com.lxf.jdk.foundation.spi.dubbo.wrapper;

import com.lxf.jdk.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

/**
 * 对扩展类的增强
 */
public class WrapperTest {
    public static void main(String[] args) {
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        //获取到的是动态生成的自适应类
        GoodsOrder goodsOrder = loader.getAdaptiveExtension();

//        URL url = URL.valueOf("www.baidu.com");
//        URL url = URL.valueOf("www.baidu.com?goods.order=wechatPay");
//        goodsOrder.payWay(url);
//        前置增强2
//        前置增强
//        pay 微信支付
//        后置增强
//        后置增强2


        /**
         * 获取直接扩展类。AliPayOrder和WechatOrder是直接扩展类，AdaptiveOrder和OrderWrapper\OrderWrapper2不是
         */
        Set<String> supportedExtensions = loader.getSupportedExtensions();
        System.out.println(supportedExtensions);//[aliPay, wechatPay]
    }
}
