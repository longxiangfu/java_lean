package com.lxf.jdk.dynamic.DynamicReflect;

/**
 * 真实实现类（目标类）
 */
public class IDivisionServiceImpl implements IDivisionService{

	public int division(int a, int b) {
		return a/b;
	}
	

}
