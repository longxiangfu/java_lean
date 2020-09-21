package com.lxf.jdk.foundation.generic;

/**
 * 泛型接口实现方式一：泛型类
 * @param <T>
 */
public class GenericInterfaceImpl1<T> implements GenericIntereface<T> {
    private T data;

    private void setData(T data){
        this.data = data;
    }

    @Override
    public T getData() {
        return this.data;
    }

    public static void main(String[] args) {
        GenericInterfaceImpl1<String> genericInterfaceImpl1 = new GenericInterfaceImpl1<>();
        genericInterfaceImpl1.setData("GenericInterfaceImpl1");
        System.out.println(genericInterfaceImpl1.getData());
    }
}
