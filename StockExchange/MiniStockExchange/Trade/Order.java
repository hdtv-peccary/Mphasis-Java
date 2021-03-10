package com.mph.trade;

import com.mph.book.BuySell;

public class Order {


    public String traderId;
    public String orderId;
    public long price;
    public long qty;
    public long stockId;
    public BuySell side;


    public Order(String traderId, String orderId, long price, long qty, long stockId, BuySell side) {
        this.traderId = traderId;
        this.orderId = orderId;
        this.price = price;
        this.qty = qty;
        this.stockId = stockId;
        this.side = side;
    }


}
