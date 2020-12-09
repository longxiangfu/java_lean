package com.lxf.jdk.jdk_E.stream;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        //演示操作IntStream
        Method method = IntStreamDemo.class.getDeclaredMethod("demo", String.class, Integer.class);
        Class<?>[] parameterTypes = method.getParameterTypes();
        String code = IntStream.range(0, parameterTypes.length)
                .mapToObj(i -> String.format("%s arg%s", parameterTypes[i].getCanonicalName(), i))
                .collect(Collectors.joining(","));
        System.out.println(code);//java.lang.String arg0,java.lang.Integer arg1

    }


    public static void demo(String name, Integer age){
        //
    }
}
