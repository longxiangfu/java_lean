//package com.lxf.reactorDemo.learn2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import reactor.bus.EventBus;
//
//import static reactor.bus.selector.Selectors.$;
//
///**
// * 将事件和事件处理程序绑定
// * @author longxiangfu
// *
// */
//@Component
//@Order(value = 1)
//public class ReactorLauncher implements CommandLineRunner {
//	@Autowired
//	private EventBus eventBus;
//	@Autowired
//	private Receiver receiver;
//	@Override
//	public void run(String... arg0) throws Exception {
//		eventBus.on($("number"), receiver);
//
//	}
//}
