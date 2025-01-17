package com.lxf.jdk.classLoader;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;

public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader());
        System.out.println(TestJDKClassLoader.class.getClassLoader());

        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("the bootstrapClassLoader:" + bootstrapClassLoader);
        System.out.println("the extClassLoader:" + extClassLoader);
        System.out.println("appClassLoader:" + appClassLoader);

        System.out.println();
        System.out.println("bootstrapClsssLoader加载以下文件：");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:
             urLs) {
            System.out.println(url);
        }
        System.out.println();
        System.out.println("extClsssLoader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println();
        System.out.println("appClsssLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));

    }
}
