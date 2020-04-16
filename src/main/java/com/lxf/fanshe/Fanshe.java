package com.lxf.fanshe;

public class Fanshe {

	public static void main(String[] args) {
		/*
		 * 获取Class对象的3种方式
		 */
		//1、通过对象方法getClass()
		Student stu1 = new Student();
		Class stu1Class = stu1.getClass();
		System.out.println(stu1Class.getName());
		//2、通过类属性class
		Class stu2Class = Student.class;
		System.out.println(stu2Class.getName());
		//3、通过类的静态方法forName(String path),类路径
		try {
			Class stu3Class = Class.forName("com.example.demo.example.fanshe.Student");
			System.out.println(stu3Class == stu2Class);//true
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
