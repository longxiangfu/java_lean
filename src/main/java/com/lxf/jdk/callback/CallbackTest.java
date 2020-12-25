package com.lxf.jdk.callback;

/**
 * 回调机制：A不用主动调用B，需要的时候B会回调A事先注册到B上的方法
 * 示例1：ajax发出调用之后，不用再主动去请求服务端成功与否，而是向服务端注册一个success事件，当服务端处理完成，
 * 并且成功之后，会回调ajax的success方法
 * 示例2：就是现在这个例子。en.setInterestingEvent(cm)，CallMe向EventNotifier上注册自己（自己的方法：interestingEvent），
 * 当somethingHappened为true时，会回调自己的interestingEvent方法
 */
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
