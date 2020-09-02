package com.lxf.jdk8.foundation.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

@SPI("aliPay")
public interface Order {
    String getPayWay();
}
