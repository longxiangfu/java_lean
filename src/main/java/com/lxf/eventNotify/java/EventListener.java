package com.lxf.eventNotify.java;

/**
 * 事件监听器。监听事件的发生，并对事件进行处理
 */
public interface EventListener {
    void onChange(Event event);
}
