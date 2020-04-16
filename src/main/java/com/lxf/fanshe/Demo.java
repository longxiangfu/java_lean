package com.lxf.fanshe;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 通过反射读取配置文件内容
 * @author 15652
 *
 */
public class Demo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		try {
			Class stuClass = Class.forName(getValue("className"));
			Method m = stuClass.getMethod(getValue("methodName"));
			m.invoke(stuClass.getConstructor().newInstance());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * 根据key从properties文件中获取对应的value
	 */
	public static String getValue(String key) throws IOException {
		Properties pro = new Properties();
		FileReader in = new FileReader("pro.txt");
		pro.load(in);
		in.close();
		return pro.getProperty(key);
	}

}
