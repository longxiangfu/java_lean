package com.lxf.jdk.foundation.spi.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * 1、通过扩展类别名获取扩展类
 * 2、通过自适应类的方式获取扩展类时,自适应类优先于自适应方法生成的动态自适应类
 */
@SPI("aliPay")
public interface GoodsOrder {
    String getPayWay();

    /**
     * Adaptive方法参数必须是URL，或包含URL的参数
     * @return
     */
    @Adaptive
    String payWay(URL url);
}
