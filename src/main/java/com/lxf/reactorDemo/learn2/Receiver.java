//package com.lxf.reactorDemo.learn2;
//
//import org.springframework.stereotype.Service;
//import reactor.bus.Event;
//
//import java.util.function.Consumer;
//
///**
// * 消费者（事件处理程序）
// * @author longxiangfu
// *
// */
//@Service
//public class Receiver implements Consumer<Event<Integer>> {
//
//	@Override
//	public void accept(Event<Integer> ev) {
//		System.out.println("process number "+ev.getData());
//
//	}
//
//
//}
