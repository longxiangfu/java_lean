package com.lxf.jdk8.foundation.spi.dubbo.activate;

import com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.List;

/**
 * 一次获取多个扩展类
 */
public class ActivateTest {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();

    }

    /**
     * 获取分组是online的扩展类，顺序按照order指定的顺序来获取，order相同时，按照配置文件中指定的顺序的倒序来获取
     */
    private static void test1() {
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        URL url = URL.valueOf("www.baidu.com");
        List<GoodsOrder> list = loader.getActivateExtension(url, "", "online");
        for (GoodsOrder goodsOrder : list) {
            System.out.println(goodsOrder.getPayWay());
        }
//        微信支付
//        支付宝支付
//        银联卡支付
    }


    /**
     * 获取分组是offline的扩展类，顺序按照order指定的顺序来获取，order越小，优先级越高
     */
    private static void test2() {
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        URL url = URL.valueOf("www.baidu.com");
        List<GoodsOrder> list = loader.getActivateExtension(url, "", "offline");
        for (GoodsOrder goodsOrder : list) {
            System.out.println(goodsOrder.getPayWay());
        }
//        银联卡支付
//        现金支付
//        优惠券支付
    }


    /**
     * 测试group和value
     */
    private static void test3() {
        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
        URL url = URL.valueOf("www.baidu.com?aaa=coupon");
        List<GoodsOrder> list = loader.getActivateExtension(url, "", "offline");//银联卡支付 现金支付
        //第二个参数和第三个参数是‘或’的关系
//        List<GoodsOrder> list = loader.getActivateExtension(url, "aaa", "offline");//银联卡支付 现金支付 优惠券支付
        for (GoodsOrder goodsOrder : list) {
            System.out.println(goodsOrder.getPayWay());
        }
    }
}
