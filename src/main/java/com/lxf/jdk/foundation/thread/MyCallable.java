package com.lxf.jdk.foundation.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("当前线程："+ Thread.currentThread().getName() + "。实现Callable");
        return "success";
    }
}
