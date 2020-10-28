package com.lxf.eventNotify.java;

/**
 * 监听器实现
 */
public class EventListenerImpl implements EventListener {
    @Override
    public void onChange(Event event) {
        System.out.println("我是默认监听器。监听到的事件：" + event.toString());
    }
}
