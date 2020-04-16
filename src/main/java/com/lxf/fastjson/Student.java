package com.lxf.fastjson;

public class Student {
	private String studentName;
	private Integer studentAge;
	
	
	public Student(String studentName, Integer studentAge) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentAge=" + studentAge + "]";
	}
	
	
	
	

}
