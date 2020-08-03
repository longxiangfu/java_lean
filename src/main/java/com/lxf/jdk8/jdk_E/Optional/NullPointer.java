package com.lxf.jdk8.jdk_E.Optional;

import java.util.Optional;

/**
 * 演示利用Optional函数，避免空指针异常
 * 演示失败，因为中间操作map(Outer::getNested)得到的Nested为null(Outer本来就为null)，待后续研究
 * @author longxiangfu
 *
 */
public class NullPointer {

	public static void main(String[] args) {
		Optional.of(new Outer())
//		.map(Outer::getNested)//若Outer不为null,则返回Nested
//		.map(Nested::getInner)//若Nested不为null,则返回Inner
//		.map(Inner::getFoo)//若Inner不为null,则返回foo
		.ifPresent(str -> System.out.println(str));
		

	}

}
