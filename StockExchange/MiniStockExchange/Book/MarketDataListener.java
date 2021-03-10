package com.mph.book;

public class MarketDataListener implements MarketListener{
    private Market market;

    public MarketDataListener(Market market) {
        this.market = market;
    }


    @Override
    public void update(OrderBook book) {

    }

    @Override
    public void trade(OrderBook book, BuySell side, long price, long size) {

    }

    public void printDepth(OrderBook book){

    }
}
