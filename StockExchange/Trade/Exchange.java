package com.mph.trade;

import com.mph.book.MarketListener;

public interface Exchange {
    public  String registerTrader(Trader trader);
    public  void registerMarketListener(MarketListener listner);
    public  void placeOrder(Order order);
    public  void deleteOrder(Order order);
    public void modifyOrder(Order order);
    public  void viewBook(long stockid);
}

