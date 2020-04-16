package com.lxf.jdk8.concurrent.multiThread;

/**
 * ThreadLocal也能实现变量线程共享，利用InheritableThreadLocal
 */
public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        ThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("龙相甫");
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("陈婷");
        new Thread(() ->{
            System.out.println(inheritableThreadLocal.get());//龙相甫
            System.out.println(threadLocal.get());//null
        }).start();
    }
}
