package com.lxf.fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射获取成员方法
 * @author 15652
 *
 */
public class MethodClass {

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			Class stuClass = Class.forName("com.example.demo.example.fanshe.Student");
			System.out.println("***获取公共方法***");
			Method[] methodArray = stuClass.getMethods();
			for(Method m : methodArray) {
				System.out.println(m);
			}
			System.out.println("***获取所有方法***");
			methodArray = stuClass.getDeclaredMethods();
			for(Method m : methodArray) {
				System.out.println(m);
			}
			System.out.println("***获取公共方法show1(),并调用***");
			Method m = stuClass.getMethod("show1", String.class);
			//实例化一个Student对象
			Object obj = stuClass.getConstructor().newInstance();
			//调用
			m.invoke(obj, "超楠");
			System.out.println("***获取所有方法，私有方法show4(),并调用***");
			m = stuClass.getDeclaredMethod("show4", int.class);
			m.setAccessible(true);//暴力反射，解除私有限定
			Object result = m.invoke(obj, 20);
			System.out.println(result);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
