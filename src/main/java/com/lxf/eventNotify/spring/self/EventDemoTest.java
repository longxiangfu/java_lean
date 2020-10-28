package com.lxf.eventNotify.spring.self;

public class EventDemoTest {
    public static void main(String[] args) {
        EventDemo  eventDemo = new EventDemo("", "100");
        EventDemoManager eventDemoManager = new EventDemoManager();
        eventDemoManager.publish(eventDemo);
    }
}
