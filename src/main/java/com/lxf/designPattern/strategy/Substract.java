package com.lxf.designPattern.strategy;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/11 17:17
 * @Version 1.0
 **/
public class Substract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
