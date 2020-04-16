package com.lxf.disruptor.disruptor;

import com.lmax.disruptor.EventHandler;

public class Handler4 implements EventHandler<Trade>{
	@Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch)
            throws Exception {
		System.out.println("handler4: append name");
        event.setName(event.getName() + "h4");
    }

}
