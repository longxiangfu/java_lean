package com.lxf.jdk8.dynamic.DynamicCGLIB;

public class MyTest {
    public static void main(String[] args) {
        CGLIBProxyFactory cglibProxyFactory = new CGLIBProxyFactory();
        SayHello sayHello = (SayHello)cglibProxyFactory.getProxy(SayHello.class);
        sayHello.say();
    }
}
