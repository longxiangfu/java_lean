//package com.lxf.jdk8.foundation.spi.dubbo.adaptive;
//
//import com.lxf.jdk8.foundation.spi.dubbo.GoodsOrder;
//import org.apache.dubbo.common.URL;
//import org.apache.dubbo.common.extension.Adaptive;
//import org.apache.dubbo.common.extension.ExtensionLoader;
//import org.apache.dubbo.common.utils.StringUtils;
//
//
///**
// * GoodsOrder接口的自适应扩展类
// * 一个接口若有自适应扩展类，那么将按照自适应扩展类指定的方式，加载接口的扩展类
// */
//@Adaptive
//public class AdaptiveGoodsOrder implements GoodsOrder {
//    //外界指定要加载的扩展类的别名
//    private String extentionName;
//    public void setExtentionName(String extentionName){
//        this.extentionName = extentionName;
//    }
//
//    @Override
//    public String getPayWay() {
//        ExtensionLoader<GoodsOrder> loader = ExtensionLoader.getExtensionLoader(GoodsOrder.class);
//        GoodsOrder GoodsOrder;
//        if (StringUtils.isBlank(extentionName)) {
//            //加载默认扩展类，即@SPI("aliPay")中指定的扩展类
//            GoodsOrder = loader.getDefaultExtension();
//        }else {
//            //加载外界指定的扩展类
//            GoodsOrder = loader.getExtension(extentionName);
//        }
//
//        return GoodsOrder.getPayWay();
//    }
//}
