package com.mph;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final OrderBook book = new OrderBook(new ArrayList<Order>(), new ArrayList<Order>());
        //Create the sell order. (amount, price, id, side, date of order).
        final Order sellOrder = new Order(2,2.50,1,OrderType.SELL,21);

        //Create the buy order. (amount, price, id, side, date of order).
        final Order buyOrder = new Order(2,1.50,2,OrderType.BUY,21);

        //Process the orders.
        book.process(sellOrder);
        //Processing an order returns the trades made. In this case we know that the order will be filled.
        ArrayList<Trade> tr = book.process(buyOrder);
        if(!tr.isEmpty()) {
            for (int i = 0; i < tr.size(); i++) {
                System.out.println(tr);
            }
        }else{
            System.out.println("no trade happened");
            }

        //}
//        Order[] or = {new Order(2, 2.50, 2, OrderType.SELL, 21),
//                new Order(2, 2.50, 1, OrderType.BUY, 21),
//                new Order(3, 7.50, 2, OrderType.BUY, 11),
//                new Order(3, 6.50, 3, OrderType.SELL, 12),
//                new Order(9, 2.50, 4, OrderType.BUY, 10)};
//
//        ArrayList<Trade> tr = null;
//        for (int i = 0; i < or.length; i++) {
//            System.out.println("giving the order to process" + or[i]);
//            tr = book.process(or[i]);
//            if(!tr.isEmpty()){
//
//                System.out.println("Trade happened"+tr);
//
//            }
        }
    }

