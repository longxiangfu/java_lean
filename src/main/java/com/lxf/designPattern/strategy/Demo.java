package com.lxf.designPattern.strategy;

/**
 * @Description 策略模式：策略不同，进行的行为不同                可以减少if else
 * 对比 工厂模式:类型不同，产生的对象不同
 * @Author Administrator
 * @DATE 2019/4/11 17:22
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        Context context = new Context(new Add());
        System.out.println("10+5=" + context.exeStrategy(10, 5));
        context = new Context(new Substract());
        System.out.println("10-5=" + context.exeStrategy(10, 5));
        context = new Context(new Multiply());
        System.out.println("10*5=" + context.exeStrategy(10, 5));
    }
}
