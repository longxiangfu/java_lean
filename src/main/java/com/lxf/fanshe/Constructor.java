package com.lxf.fanshe;

import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射获取构造方法并使用
 * @author 15652
 *
 */
public class Constructor {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//加载Class对象
		Class classz = null;
		try {
			classz = Class.forName("com.example.demo.example.fanshe.Student");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("***获取所有公有构造方法***");
		java.lang.reflect.Constructor[] conArray = classz.getConstructors();
		for(java.lang.reflect.Constructor c : conArray) {
			System.out.println(c);
		}
		
		System.out.println("***获取所有构造方法***");
		conArray = classz.getDeclaredConstructors();
		for(java.lang.reflect.Constructor c : conArray) {
			System.out.println(c);
		}
	
		System.out.println("***获取公有无参构造方法***");
		java.lang.reflect.Constructor con = null;
		try {
			con = classz.getConstructor();//因为获取无参构造，所以可以不用加参数
			System.out.println("con = " + con);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***获取所有构造方法，参数类型为char,并调用***");
		try {
			con = classz.getDeclaredConstructor(char.class);
			System.out.println(con);
			try {
				Object obj = con.newInstance("楠");//调用构造方法
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

}
