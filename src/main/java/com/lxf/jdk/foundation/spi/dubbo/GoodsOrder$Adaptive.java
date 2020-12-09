package com.lxf.jdk.foundation.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * Adaptive方法自动生成Adaptive类，生成在target目录下，这里是手工拷过来的
 * 没有自适应的方法的调用将报错
 */
public class GoodsOrder$Adaptive implements com.lxf.jdk.foundation.spi.dubbo.GoodsOrder {
    public java.lang.String getPayWay()  {
        throw new UnsupportedOperationException("The method public abstract java.lang.String com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder.getPayWay() of interface com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder is not adaptive method!");
    }
    public java.lang.String payWay(org.apache.dubbo.common.URL arg0)  {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg0;
        String extName = url.getParameter("goods.order", "aliPay");
        if(extName == null) throw new IllegalStateException("Failed to get extension (com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder) name from url (" + url.toString() + ") use keys([goods.order])");
        com.lxf.jdk.foundation.spi.dubbo.GoodsOrder extension = (com.lxf.jdk.foundation.spi.dubbo.GoodsOrder)ExtensionLoader.getExtensionLoader(com.lxf.jdk.foundation.spi.dubbo.GoodsOrder.class).getExtension(extName);
        return extension.payWay(arg0);
    }
}
