package com.lxf.jdk.jdk_E;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private String id;
	private String name;
	private String sex;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
