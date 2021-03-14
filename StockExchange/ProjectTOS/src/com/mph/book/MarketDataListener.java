package com.mph.book;

public class MarketDataListener implements MarketListener {
    private Market market;

    public MarketDataListener(Market market) {
        this.market = market;
    }


    //TODO
    @Override
    public void update(OrderBook book) {

    }

    //TODO
    @Override
    public void trade(OrderBook book, BuySell side, long price, long size) {

    }

    //TODO
    public void printDepth(OrderBook book) {

    }
}
