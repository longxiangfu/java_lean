package com.lxf.designPattern.chainPattern;

/**
 * @Description 责任链：由多个处理器处理，当一个处理器处理不了的话，交给下一个处理器，直到被责任链上的处理器处理
 * 对比命令模式：命令具有选择的特点，当符合某处理器处理时，就处理
 * @Author Administrator
 * @DATE 2019/4/11 16:05
 * @Version 1.0
 **/
public class Demo {
    public static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger abstractLogger = getChainOfLoggers();
        abstractLogger.logMessage(AbstractLogger.INFO, "this is a console info");
        abstractLogger.logMessage(AbstractLogger.DEBUG, "this is a debug info");
        abstractLogger.logMessage(AbstractLogger.ERROR, "this is a error info");
    }
}
