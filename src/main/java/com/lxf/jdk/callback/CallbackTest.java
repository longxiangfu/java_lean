package com.lxf.jdk.callback;

public class CallbackTest {
    public static void main(String[] args) {
        CallMe cm = new CallMe();  //待回调用的对象1
        CallYou cy = new CallYou(); //待回调用的对象2
        EventNotifier en = new EventNotifier(); //回调事件主体对象，此例在构造函数阶段进行事件触发标识
        en.setInterestingEvent(cm); //将待回调对象1设置到主体方法内
        en.doWork(); //当执行主体对象的方法时，检测标识是否为真，如果为真，则同时调用了待回调对象1的实现//接口预先定义的方法
        en.setInterestingEvent(cy);//将待回调对象2设置到主体方法内
        en.doWork();//当执行主体对象的方式时，检测标识是否为真，如果为真，则同时调用了待回调对象1的实现//接口预先定义的方法
    }
}
