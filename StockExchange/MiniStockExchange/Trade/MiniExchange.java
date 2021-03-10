package com.mph.trade;

import com.mph.book.MarketListener;
import com.mph.book.Trader;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class MiniExchange implements Exchange {

    Map<String, Trader> trader=null;
    long traderid = 100;
    ExecutorService executor=null;

    public MiniExchange() {
    }

    public void validate(Order order){

    }

    @Override
    public String registerTrader(Trader trader) {
        return null;
    }

    @Override
    public void registerMarketListener(MarketListener listner) {

    }

    @Override
    public void placeOrder(Order order) {

    }

    @Override
    public void deleteOrder(Order order) {

    }

    @Override
    public void modifyOrder(Order order) {

    }

    @Override
    public void viewBook(long stockid) {

    }

}
