package com.mph.book;

public interface MarketListener {


    public void update(OrderBook book);

    public void trade(OrderBook book, BuySell side, long price, long size);
}
