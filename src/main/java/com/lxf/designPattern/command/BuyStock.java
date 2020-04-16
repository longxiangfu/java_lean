package com.lxf.designPattern.command;

public class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock){
        this.stock = stock;
    }

    @Override
    public Boolean support(Stock stock) {
        if (stock.getType() != null) {
            return 0 == stock.getType().intValue();
        }
        return null;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
