package com.lxf.designPattern.command;

/**
 * 命令模式测试
 */
public class Demo {
    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.setType(1);
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        broker.invokeOrder(stock);
    }
}
