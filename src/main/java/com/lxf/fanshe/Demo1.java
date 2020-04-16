package com.lxf.fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射越过泛型检查
 * @author 15652
 *
 */
public class Demo1 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaa");

		
		Class listClass = strList.getClass();
		Method m = listClass.getMethod("add", Object.class);
		m.invoke(strList, 100);
		
		for(Object obj : strList) {
			System.out.println(obj);
		}

	}

}
