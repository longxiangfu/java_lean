package com.lxf.disruptor.disruptor;

import com.lmax.disruptor.EventHandler;

public class Handler1 implements EventHandler<Trade>{
	@Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch)
            throws Exception {
        System.out.println("handler1: set name");
        event.setName("h1");
    }

}
