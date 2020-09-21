package com.lxf.jdk.jdk_E;

/**
 * 函数式接口
 * @author Administrator
 *
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
//	T convert1(F from1);
	//jdsigjsjjs

}
