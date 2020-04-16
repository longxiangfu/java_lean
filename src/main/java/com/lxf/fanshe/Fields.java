package com.lxf.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射获取成员变量并使用
 * @author 15652
 *
 */
public class Fields {

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException {
		try {
			Class stuClass = Class.forName("com.example.demo.example.fanshe.Student");
			
			System.out.println("***获取公有字段***");
			Field[] fieldArray = stuClass.getFields();
			for(Field f : fieldArray) {
				System.out.println(f);
			}
			System.out.println("***获取所有字段***");
			fieldArray = stuClass.getDeclaredFields();
			for(Field f : fieldArray) {
				System.out.println(f);
			}
			
			System.out.println("***获取公有字段,并调用***");
			Field f = stuClass.getField("name");
			System.out.println(f);
			//获取一个对象
			Object obj = stuClass.getConstructor().newInstance();
			//为字段设置值
			f.set(obj, "超楠");
			//验证
			Student stu = (Student)obj;
			System.out.println("验证姓名:" + "超楠".equals(stu.name));
			
			System.out.println("***获取所有字段中的私有字段,并调用***");
			f = stuClass.getDeclaredField("phoneNum");
			System.out.println(f);
			f.setAccessible(true);//暴力反射，解除私有限定，否则无法为私有属性设置值
			f.set(obj, "15201220208");
			System.out.println("验证电话：" + stu);
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}

}
