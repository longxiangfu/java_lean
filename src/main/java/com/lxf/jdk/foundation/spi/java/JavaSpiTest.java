package com.lxf.jdk.foundation.spi.java;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Spliterator;

import static java.util.ServiceLoader.load;
import static java.util.stream.StreamSupport.stream;





/**
 * java spi测试
 * 有个缺点，就是必须加载出服务提供者接口的所有实现类
 * dubbo的spi解决了这个问题
 */
public class JavaSpiTest {
    public static void main(String[] args) {
        //提供者一个一个循环出
        //调用hasNext()时才去解析"/META-INF/services/"下的配置文件，并且在调用next时，才对具体的实现类进行实例化
//        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
////        Iterator<Animal> iterator = load.iterator();
////        while (iterator.hasNext()) {
////            Animal animal = iterator.next();
////            System.out.println(animal.getName());
//        }

        //一次拿出所有提供者
        ServiceLoader<Animal> serviceLoader = load(Animal.class);
        Spliterator<Animal> spliterator = serviceLoader.spliterator();
        Animal[] animals = stream(spliterator, false).toArray(Animal[]::new);
        System.out.println(Arrays.toString(animals));

    }
}
