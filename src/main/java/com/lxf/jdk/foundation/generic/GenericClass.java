package com.lxf.jdk.foundation.generic;

/**
 * 泛型类
 */
public class GenericClass<T> {
    private T data;

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data = data;
    }


    public static void main(String[] args) {
        GenericClass<String> genericClass = new GenericClass();
        genericClass.setData("genericClass");
        System.out.println(genericClass.getData());
    }

}
