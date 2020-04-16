package com.lxf.designPattern.chainPattern;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/11 15:33
 * @Version 1.0
 **/
public class ConsoleLogger extends AbstractLogger {
        public ConsoleLogger(Integer level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console Logger: " + message);
    }
}
