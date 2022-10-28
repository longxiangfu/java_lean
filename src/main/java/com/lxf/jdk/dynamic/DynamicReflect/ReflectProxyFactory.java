package com.lxf.jdk.dynamic.DynamicReflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 * @author 15652
 *
 */
public class ReflectProxyFactory {

	public static Object getProxy(final Object target) {
		return Proxy.newProxyInstance(
				// 目标类类加载器
				target.getClass().getClassLoader(),
				// 实现目标类接口
				target.getClass().getInterfaces(),
				// 拦截器
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxyObject, Method method, Object[] args) throws Throwable {
						System.out.println("前置业务");
						int b = (int)args[1];
						//处理次要逻辑
						if(b == 0) {
							throw new RuntimeException("被除数不能为0");
						}
						//处理主逻辑
						Object result = method.invoke(target, args);
						System.out.println("前置业务");
						return result;
					}

				}
				);

		}

}
