package com.lxf.disruptor.disruptor;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;

public class TradePublisher implements Runnable{
	private Disruptor<Trade> disruptor;
    private static final int LOOP = 100;// 模拟百次交易的发生

    public TradePublisher(Disruptor<Trade> disruptor) {
        this.disruptor = disruptor;
    }

    @Override
    public void run() {
        TradeEventTranslator tradeTransloator = new TradeEventTranslator();
        for (int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(tradeTransloator);
        }
    }
}

class TradeEventTranslator implements EventTranslator<Trade> {
    private Random random = new Random();
    @Override
    public void translateTo(Trade event, long sequence) {
        this.generateTrade(event);
    }
    private Trade generateTrade(Trade trade) {
        trade.setPrice(random.nextDouble() * 9999);
        return trade;
    }

}
