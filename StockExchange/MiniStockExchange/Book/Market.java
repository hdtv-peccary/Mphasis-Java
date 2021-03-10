package com.mph.book;

public class Market {
    private OrderBook books;
    private BookOrder orders;
    private MarketListener listener;

    public Market() {
    }

    public void registerListener(MarketListener listener){

    }

    public OrderBook open(long securityId){
        return null;
    }

    public  BookOrder find(long orderId){
        return null;
    }

    public void add(long instrument, long orderId, BuySell side,long price,long size){

    }
    public void doMatching(OrderBook book,boolean bbo,long orderId,long size,long price){

    }
    public void modify(long orderId,long size){

    }
    public long execute(long orderId,long quantity){
        return 1L;
    }
    public long execute(long orderId, long quantity, long price){
        return 1l;
    }
    public long execute(long orderId,BookOrder order,long quantity,long price){
        return 1L;
    }
    public long cancel(long orderId,long quantity){
        return 1l;
    }
    public void delete(long orderId){

    }




}
