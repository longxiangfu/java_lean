package com.lxf.jdk.callback;

public class CallYou implements InterestingEvent {

    public CallYou(){}

    @Override
    public void interestingEvent() {
        System.out.println("实现了查询");
    }
}
