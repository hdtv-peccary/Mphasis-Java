package com.mph.trade;


import com.mph.book.BookOrder;
import com.mph.book.BuySell;
import com.mph.book.Market;
import com.mph.book.OrderBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExchangeMain {
    public static void main(String[] args) throws IOException {
        ExchangeMain.showOptions();

        MiniExchange ex = new MiniExchange();
        String result = ex.registerTrader(new Trader("priya","97898","addr1"));
        String result2 = ex.registerTrader(new Trader("ajay","97910","addr2"));
        System.out.println(result);
        System.out.println(result2);
        System.out.println(ex.getAllTraders());
        System.out.println(ex.updateTrader(new Trader("priya","8765","addr2","97898")));

        ex.placeOrder(new Order("9456",13,4,3, BuySell.SELL ));
        System.out.println(ex.getAllOrders());
        //long orderId, BookOrder order, long quantity, long price){
        //long price, OrderBook book, BuySell side,long size)


        OrderBook orderbook = new OrderBook(3);
        BookOrder ob =new BookOrder(2,orderbook,BuySell.SELL,2);
        Market m = new Market();
        m.execute(12,ob,2,2);

    }

    public static void showOptions() throws IOException {


    }






}
