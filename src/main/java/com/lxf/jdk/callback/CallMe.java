package com.lxf.jdk.callback;

public class CallMe implements InterestingEvent {

    public CallMe(){}

    @Override
    public void interestingEvent() {
        System.out.println("实现了打印");
    }
}
