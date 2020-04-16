package com.lxf.fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射或main方法，并调用
 * @author 15652
 *
 */
public class Main {

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			Class classz = Class.forName("com.example.demo.example.fanshe.Student");
			Method methodMain = classz.getMethod("main", String[].class);
			//第一个参数：对象类型，因为方法是static静态的，所以可以为null
			methodMain.invoke(null, new String[] {"a","b","c"});
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
