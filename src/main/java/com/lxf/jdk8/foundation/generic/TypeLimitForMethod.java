package com.lxf.jdk8.foundation.generic;

/**
 * 泛型类型限定-方法
 * 使用extends关键字，关键字后面跟类和接口，类在前面，接口在后面，中间用&相连，如<T extends ArrayList & Comparable & Serializable>
 * */
public class TypeLimitForMethod {
    private static <T extends Comparable> T getMin(T a, T b){
        return (a.compareTo(b)<0) ? a : b;
    }
    

    public static void main(String[] args) {
        System.out.println(TypeLimitForMethod.getMin(1, 2));
        System.out.println(TypeLimitForMethod.getMin("a", "r"));
    }
}
