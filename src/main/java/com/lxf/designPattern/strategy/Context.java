package com.lxf.designPattern.strategy;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/11 17:19
 * @Version 1.0
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int exeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
