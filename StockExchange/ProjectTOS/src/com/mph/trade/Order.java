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

    public Order(String traderId, long price, long qty, long stockId, BuySell side) {
        this.traderId = traderId;
        this.price = price;
        this.qty = qty;
        this.stockId = stockId;
        this.side = side;
    }

    public String getTraderId() {
        return traderId;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public BuySell getSide() {
        return side;
    }

    public void setSide(BuySell side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Order{" +
                "traderId='" + traderId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", stockId=" + stockId +
                ", side=" + side +
                '}';
    }
}
