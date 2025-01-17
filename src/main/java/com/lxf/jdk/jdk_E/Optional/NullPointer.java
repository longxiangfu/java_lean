package com.lxf.jdk.jdk_E.Optional;

import org.redisson.misc.Hash;

import java.util.HashMap;
import java.util.Optional;

/**
 * 演示利用Optional函数，避免空指针异常。主要应用在链式操作中,平时的操作也可以。包装单个对象
 * 平时这样写：
 * String str = "";
 * if (StringUtils.isNotBlank(str)) {
 *		// TODO
 * }else {
 *     throw new RuntimeException();
 * }
 * 现在只需要这样写,非常简单：
 * String str = "";
 * Optional.ofNullable(str).orElseThrow(RuntimeException::new);
 *
 * 参考：https://mp.weixin.qq.com/s/lzVQlXKkW6-TmvhyA2b5Hw
 *
 * @author longxiangfu
 *
 */
public class NullPointer {

	public static void main(String[] args) {
		/**
		 * Optional一般只判断对象
		 * 其他的像String  HashMap  List使用Hutool工具
		 */
		Outer outer = new Outer();
		Nested nested = new Nested();
		Inner inner = new Inner();
		inner.setFoo("foo");
//		nested.setInner(inner);
		outer.setNested(nested);
		String foo = Optional.ofNullable(outer)
				.map(Outer::getNested)
				.map(Nested::getInner)
				.map(Inner::getFoo)
//				.orElseThrow(RuntimeException::new);
		        .orElseThrow(() -> new RuntimeException("运行时异常"));
		System.out.println("foo:" + foo); // foo:foo


	}

}
