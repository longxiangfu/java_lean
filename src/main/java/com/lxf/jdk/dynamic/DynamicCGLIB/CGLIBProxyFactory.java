package com.lxf.jdk.dynamic.DynamicCGLIB;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * 代理工厂
 */
public class CGLIBProxyFactory{

    /**
     * 获取代理
     * @param target 目标类
     * @return
     */
    public static Object getProxy(final Object target){
        // 实例化增强类
        Enhancer enhancer = new Enhancer();
        // 继承目标类
        enhancer.setSuperclass(target.getClass());
        // 添加了两个拦截器
        enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
            /**
             * 拦截器
             * @param proxy 代理对象
             * @param method 目标方法
             * @param args 目标方法参数
             * @param methodProxy 代理方法
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("前置业务");
                Object result = method.invoke(target, args);
                System.out.println("后置业务");
                return result;
            }
        }, NoOp.INSTANCE});
        // 不同的方法对应不同的拦截器
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("say")) { // say方法用第一个拦截器
                    return 0;
                }else { // sayHello方法使用第二个拦截器
                    return 1;
                }
            }
        });
        //创建代理类（目标类子类）
        return enhancer.create();
    }

}
