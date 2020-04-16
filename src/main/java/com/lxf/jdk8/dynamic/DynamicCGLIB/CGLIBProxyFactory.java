package com.lxf.jdk8.dynamic.DynamicCGLIB;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理工厂
 */
public class CGLIBProxyFactory implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    /**
     * 获取代理
     * @param targetClass
     * @return
     */
    public Object getProxy(Class targetClass){
        //设置目标类
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(this);
        //创建代理类（目标类子类）
        return enhancer.create();
    }


    /**
     * 拦截器
     * @param target
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置业务");
        Object result = methodProxy.invokeSuper(target, args);
        System.out.println("后置业务");
        return result;
    }
}
