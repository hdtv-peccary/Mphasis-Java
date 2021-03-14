package com.mph.book;

import java.util.ArrayList;

public class OrderBook {
    private long instrument;
    private long bids;
    private long asks;


    public OrderBook(long instrument) {
        this.instrument = instrument;
    }

    public long getBestBidPrice() {
        return 1l;
    }

    public ArrayList<Long> getBidPrices() {
        return null;
    }

    public long getBidSize(long price) {
        return 1l;
    }

    public long getBestAskPrice() {
        return 1l;
    }

    public ArrayList<Long> getAskPrices() {
        return null;
    }

    public long getAskSize(long price) {
        return 1l;
    }

    public boolean add(BuySell side, long price, long quantity) {
        return true;
    }

    public boolean update(BuySell side, long price, long quantity) {
        return true;
    }

}
