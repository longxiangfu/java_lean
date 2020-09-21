package com.lxf.jdk.foundation.spi.dubbo.adaptive;

import com.lxf.jdk.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * Adaptive方法测试
 * 会动态自动生成Adaptive类
 * 通过自适应方法动态生成自适应类的方式，加载扩展类
 * Adaptive方法优先级高于Adaptive类
 */
public class AdaptiveMethodTest {
    public static void main(String[] args) {
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        //获取到的是动态生成的自适应类
        GoodsOrder goodsOrder = loader.getAdaptiveExtension();

//        URL url = URL.valueOf("www.baidu.com");
        URL url = URL.valueOf("www.baidu.com?goods.order=wechatPay");
        System.out.println(goodsOrder.payWay(url));

    }
}
