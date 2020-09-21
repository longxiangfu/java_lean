package com.lxf.jdk.jdk_E;

/**
 * java8的接口定义
 * @author Administrator
 *
 */
public interface Formula {
	double calculate(int a);
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

}
