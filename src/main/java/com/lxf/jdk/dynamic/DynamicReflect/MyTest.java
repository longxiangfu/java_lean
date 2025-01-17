package com.lxf.jdk.dynamic.DynamicReflect;

/**
 * 测试
 */
public class MyTest {
	
	public static void main(String[] args) {
		//创建目标对象
		IDivisionServiceImpl idsi = new IDivisionServiceImpl();
		//根据目标类创建目标类的代理对象
		IDivisionService iDivisionService = (IDivisionService)ReflectProxyFactory.getProxy(idsi);
		int conresult = iDivisionService.division(5, 1);
		System.out.println("两数相除为：" + conresult);
		
		
	}

}
