package com.lxf.jdk.foundation.spi.java;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * java spi测试
 * 有个缺点，就是必须加载出服务提供者接口的所有实现类
 * dubbo的spi解决了这个问题
 */
public class JavaSpiTest {
    public static void main(String[] args) {
        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
        Iterator<Animal> iterator = load.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            System.out.println(animal.getName());
        }
    }
}
