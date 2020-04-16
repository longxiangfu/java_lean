package com.lxf.fastjson;

public class Course {
	
	private String courseName;
	private Integer code;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Course(String courseName, Integer code) {
		super();
		this.courseName = courseName;
		this.code = code;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", code=" + code + "]";
	}
	
	

}
