package com.lxf.designPattern.chainPattern;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/11 15:33
 * @Version 1.0
 **/
public class FileLogger extends AbstractLogger {
        public FileLogger(Integer level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Logger: " + message);
    }
}
