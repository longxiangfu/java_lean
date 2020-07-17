package com.lxf.jdk8.foundation.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * java spi测试
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
