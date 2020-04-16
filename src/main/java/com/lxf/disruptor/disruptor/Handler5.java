package com.lxf.disruptor.disruptor;

import com.lmax.disruptor.EventHandler;

public class Handler5 implements EventHandler<Trade>{
	@Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch)
            throws Exception {
		System.out.println("handler5: add price");
        event.setPrice(event.getPrice() + 3.0);
    }

}
