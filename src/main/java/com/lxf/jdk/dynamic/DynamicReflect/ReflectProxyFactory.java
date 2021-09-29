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

		Object angencyObj = null;
		angencyObj = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), // 实现目标类接口
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxyObject, Method method, Object[] args) throws Throwable {
						int a = (int)args[0];
						int b = (int)args[1];
						//处理次要逻辑
						if(b == 0) {
							System.out.println("出数不能为0");
							return -1;
						}
						if(a == 0) {
							return 0;
						}
						//处理主逻辑
						Object result = method.invoke(target, args);
						return result;
					}

				}

				);
		return angencyObj;

		}

}
