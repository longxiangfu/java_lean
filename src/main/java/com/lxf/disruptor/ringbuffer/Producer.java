package com.lxf.disruptor.ringbuffer;

import com.lmax.disruptor.RingBuffer;

public class Producer {
	private final RingBuffer<Order> ringBuffer;
	
    public Producer(RingBuffer<Order> ringBuffer){
        this.ringBuffer = ringBuffer;
    }
    
    public void produceData(String data){
        long sequence = ringBuffer.next();
        try {
            Order order = ringBuffer.get(sequence);
            order.setId(data);
        } finally {
            ringBuffer.publish(sequence);
        }
    }

}
