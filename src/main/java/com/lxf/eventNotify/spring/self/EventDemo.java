package com.lxf.eventNotify.spring.self;

import org.springframework.context.ApplicationEvent;

/**
 * 事件
 */
public class EventDemo extends ApplicationEvent {

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EventDemo(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
