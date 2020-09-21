package com.lxf.jdk.foundation.generic;

/**
 * 泛型接口实现方式二：指定具体类型
 */
public class GenericInterfaceImpl2 implements GenericIntereface<String> {

    @Override
    public String getData() {
        return "GenericInterfaceImpl2";
    }


    public static void main(String[] args) {
        GenericInterfaceImpl2 genericInterfaceImpl2 = new GenericInterfaceImpl2();
        System.out.println(genericInterfaceImpl2.getData());
    }

}
