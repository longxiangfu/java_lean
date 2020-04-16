package com.lxf.jdk8.foundation.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类型限定-类
 */
public class TypeLimitForClass<T extends List & Serializable> {
    private T data;

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        TypeLimitForClass<ArrayList> typeLimitForClass = new TypeLimitForClass<>();
        typeLimitForClass.setData(list);
        TypeLimitForClass<ArrayList> typeLimitForClass1 = new TypeLimitForClass<>();
        typeLimitForClass1.setData(list1);

        System.out.println(getMin(typeLimitForClass.getData().size(), typeLimitForClass1.getData().size()));

    }

    public static  <T extends Comparable<T>> T getMin(T a, T b){
        return (a.compareTo(b)<0) ? a : b;
    }
}
