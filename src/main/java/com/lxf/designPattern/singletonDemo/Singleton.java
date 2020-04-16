package com.lxf.designPattern.singletonDemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/25 18:43
 * @Version 1.0
 **/
public class Singleton{
    //1、饿汉(利用类的加载机制，做成静态成员变量或静态代码块)
//    private static Singleton instance = new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return instance;
//    }

//    private static Singleton instance = null;
//    static {
//        instance = new Singleton();
//    }
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return instance;
//    }

    //2、利用静态内部类，使用了延迟加载（只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance）
//    private static class SingletonHolder{
//        private static final Singleton INSTANCE = new Singleton();
//    }
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return SingletonHolder.INSTANCE;
//    }

    //3、枚举  Singleton1   建议使用
    //4、cas  不建议使用
    private static final AtomicReference<Singleton> reference = new AtomicReference<>();
    private Singleton(){}
    public static Singleton getInstance(){
        for (;;){//cas是基于忙等待的算法，依赖底层硬件实现，此处容易造成死循环
            Singleton instance = reference.get();
            if (instance != null) {
                return instance;
            }
            instance = new Singleton();//高并发时容易造成内存溢出
            if (reference.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }




    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.INSTANCE;//获取Singleton1的实例
        singleton1.whateverMethod();
    }


}
