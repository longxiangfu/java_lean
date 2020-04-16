package com.lxf.designPattern.chainPattern;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/11 15:24
 * @Version 1.0
 **/
public abstract class AbstractLogger {
    public static Integer INFO = 1;
    public static Integer DEBUG = 2;
    public static Integer ERROR = 3;

    public Integer level;

    public AbstractLogger nextLogger;
    public void setNextLogger(AbstractLogger abstractLogger) {
        this.nextLogger = abstractLogger;
    }

    public void logMessage(Integer level, String message){
        if (this.level <= level) {
            write(message);
        }else{
            if(this.nextLogger != null){
                this.nextLogger.logMessage(level, message);
            }
        }

    }

    abstract protected void write(String message);
}
