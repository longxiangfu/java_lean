package com.lxf.designPattern.command;

public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock){
        this.stock = stock;
    }

    @Override
    public Boolean support(Stock stock) {
        if (stock.getType() != null) {
            return 1 == stock.getType().intValue();
        }
        return null;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
