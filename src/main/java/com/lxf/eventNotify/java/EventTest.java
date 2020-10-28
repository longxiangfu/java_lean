package com.lxf.eventNotify.java;

public class EventTest {
    public static void main(String[] args) {
        //创建事件管理器
        EventManager eventManager = new EventManager();
        //向监听器容器中添加监听器
        eventManager.addListener((event) -> System.out.println("我是匿名类监听器。监听到的事件：" + event.toString()));
        eventManager.addListener(new EventListenerImpl());
        //触发事件
        eventManager.postEvent(new Event("", "89"));
    }
}
