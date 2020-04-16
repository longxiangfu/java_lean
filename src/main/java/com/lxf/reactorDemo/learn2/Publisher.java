//package com.lxf.reactorDemo.learn2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import reactor.bus.Event;
//import reactor.bus.EventBus;
//
///**
// * 生产者（事件发送程序）
// * @author longxiangfu
// *
// */
//@Controller
//public class Publisher {
//	@Autowired
//	EventBus eventBus;
//
//	@RequestMapping("reactor/demo")
//	@ResponseBody
//	public void publish() throws InterruptedException{
//		for(int i = 0; i < 10; i++) {
//			eventBus.notify("number", Event.wrap(i));
//		}
//	}
//
//}
