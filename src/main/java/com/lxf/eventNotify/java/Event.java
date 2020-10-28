package com.lxf.eventNotify.java;

import java.util.EventObject;

/**
 * 事件
 */
public class Event extends EventObject {

    private String str;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public Event(Object source, String str) {
        super(source);
        this.str = str;
    }

    @Override
    public String toString() {
        return "Event{" +
                "str='" + str + '\'' +
                '}';
    }
}
