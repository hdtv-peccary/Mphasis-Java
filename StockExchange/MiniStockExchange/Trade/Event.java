package com.mph.trade;

public class Event {

    private Order order;
    private OrderRequestType requestType;



    public Event(Order order, OrderRequestType requestType) {
        this.order = order;
        this.requestType = requestType;
    }
}


