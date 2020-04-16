package com.lxf.reactor;

public class ReactorSample8 {
	public static void main(String[] args) {	
//		Flux flux = Flux.create(new Consumer<FluxSink<String>>() {
//			@Override
//			public void accept(FluxSink<String> t) {
//				t.onRequest(new LongConsumer() {
//					@Override
//					public void accept(long value) {
//						System.err.println(value);
//						for(int i=0;i<5;i++) {
//							System.err.println("-----------"+i);
//							t.next("Product生产的第"+i+"个商品（生产此商品的线程为："+Thread.currentThread().getName()+")");
//						}
//					}
//				});
//			}
//			
//		});
//		
//		flux.subscribe(e->System.out.println("Consumer1  消费了"+e+"此时消费者的线程为："+Thread.currentThread().getName()));
//	}	
//}



// public static <T> Flux<T> create(Consumer<? super FluxSink<T>> emitter) {
//	    return create(emitter, OverflowStrategy.BUFFER);
//    }
//以编程方式创建一个Flux，该Flux能够以同步或异步的方式通过FrupSink API发出多个元素。
//如果您想要适应其他多值异步API，而不担心取消和背压(如果下游不能跟上，则通过缓冲所有信号来处理)，那么这个Flux工厂是有用的。
//例如：
// Flux.<String>create(emitter -> {
//     ActionListener al = e -> {
//         emitter.next(textField.getText());
//     };
//     // 没有清理支持：
//     button.addActionListener(al);
//     //没有清理支持：
//     button.addActionListener(al);
//     emitter.onDispose(() -> {
//         button.removeListener(al);
//     });
// });

//类型参数：<T>序列中的值类型参数：发射器使用反应器为每个订阅者提供的FrupSink来生成信号。


//@FunctionalInterface
//public interface Consumer<T> {
// 	void accept(T t);
//}
//表示接受单个输入参数并不返回结果的操作。与大多数其他功能接口不同，消费者期望通过副作用操作。
//这是一个功能接口，其功能方法是接受（对象）。
//<T>操作输入的类型

//public interface FluxSink<T> {
//void complete();
//Context currentContext();
//void error(Throwable e);
//FluxSink<T> next(T t);
//long requestedFromDownstream();
//boolean isCancelled();
//FluxSink<T> onRequest(LongConsumer consumer);
//FluxSink<T> onCancel(Disposable d);
//FluxSink<T> onDispose(Disposable d);
//}
//Wrapper API around a downstream Subscriber for emitting any number of next signals followed by zero or one onError/onComplete. 
//包装器API围绕下游订阅服务器发出任意数量的下一个信号，然后是零或一个onError/onComplete。

//
//FluxSink<T> onRequest(LongConsumer consumer);
//将一个LongConsuer附加到此FrupSink，它将被通知对此接收
	}
}