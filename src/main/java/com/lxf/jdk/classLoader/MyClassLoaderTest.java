package com.lxf.jdk.classLoader;

import cn.hutool.core.io.resource.ResourceUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try{
                byte[] bytes = this.loadByte(name);
                return defineClass(name, bytes, 0, bytes.length);
            }catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }

        }

        private byte[] loadByte(String name) {
            String replaceName = name.replace("\\.", "/");
            byte[] bytes = ResourceUtil.readBytes(classPath + "/" + replaceName + ".class");
            return bytes;
        }

    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\test");
        Class<?> aClass = myClassLoader.loadClass("com.lxf.jdk.classLoader.User1");
        Object instance = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(instance, null);
        System.out.println(aClass.getClassLoader().getClass().getName());
    }
}
