package com.mph.book;


public class BookOrder {
    private long price;
   private long remainingQuantity;
    private OrderBook book;
   private BuySell side;
    //market ong instrument, long orderId, BuySell side,long price,long size

    public BookOrder(long price, OrderBook book, BuySell side,long size) {
        this.price = price;
        this.book = book;
        this.side = side;
    }

    public OrderBook getBook() {
        return book;
    }

    public void setBook(OrderBook book) {
        this.book = book;
    }

    public void setRemaininingQuantity(long remainingquantity){

    }
    public void reduce(long quantity){

    }
}

