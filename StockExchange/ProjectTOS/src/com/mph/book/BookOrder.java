package com.mph.book;


public class BookOrder {
    private long price;
    private OrderBook book;
    private BuySell side;


    public BookOrder(long price, OrderBook book, BuySell side) {
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

}

