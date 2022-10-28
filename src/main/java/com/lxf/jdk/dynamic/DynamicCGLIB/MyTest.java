package com.lxf.jdk.dynamic.DynamicCGLIB;

public class MyTest {
    public static void main(String[] args) {
        // 创建目标类对象
        SayHello target = new SayHello();
        // 创建目标类代理对象
        SayHello proxy = (SayHello)CGLIBProxyFactory.getProxy(target);
        proxy.say();
//        proxy.sayHello();
    }
}
