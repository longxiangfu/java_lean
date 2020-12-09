package com.lxf.jdk.other.loadResource;

import com.lxf.jdk.other.Duplicate;

import java.util.Enumeration;

/**
 * 资源加载器
 */
public class ResourceLoader {

    public static void main(String[] args) {
        System.out.println(Duplicate.class.getName());//类的全限定名  com.lxf.jdk.other.Duplicate
        loadFile(Duplicate.class.getName().replace('.', '/') + ".class");
    }

    /**
     * 加载文件
     * @param fileName
     */
    public static void loadFile(String fileName){
        System.out.println(fileName);//   com/lxf/jdk/other/Duplicate.class
        try{
            Enumeration<java.net.URL> urls = null;
            ClassLoader classLoader = findClassLoader(ResourceLoader.class);

            if (urls == null || !urls.hasMoreElements()) {
                if (classLoader != null) {
                    urls = classLoader.getResources(fileName);
                } else {
                    urls = ClassLoader.getSystemResources(fileName);
                }
            }

            if (urls != null) {
                System.out.println(urls.hasMoreElements());// true
                while (urls.hasMoreElements()) {
                    java.net.URL resourceURL = urls.nextElement();
                    System.out.println(resourceURL);//  file:/I:/workspace-lxf/java_lean/target/classes/com/lxf/jdk/other/Duplicate.class
                    //TODO  解析文件内容
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 查找类加载器
     * @param clazz
     * @return
     */
    private static ClassLoader findClassLoader(Class<?> clazz) {
        ClassLoader classLoader = null;
        try {
            //获取当前线程环境ClassLoader
            classLoader = Thread.currentThread().getContextClassLoader();
            if (classLoader == null) {
                //当前线程环境ClassLoader为null时，获取clazz的ClassLoader
                classLoader = clazz.getClassLoader();
                if (classLoader == null) {
                    //当clazz的ClassLoader为null时，获取启动类加载器
                    classLoader = ClassLoader.getSystemClassLoader();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return classLoader;
    }
}
