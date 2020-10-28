package com.lxf.eventNotify.java;

import java.util.HashSet;

/**
 * 事件管理器
 */
public class EventManager {
    //存储监听
    private HashSet<EventListener> listeners = new HashSet<>();

    /**
     * 添加监听
     * @param listener
     */
    public void addListener(EventListener  listener){
        if (listener == null) {
            return;
        }
        listeners.add(listener);
    }

    /**
     * 触发事件
     * @param event
     */
    public void postEvent(Event event){
        for (EventListener listener : listeners) {
            listener.onChange(event);
        }
    }
}
