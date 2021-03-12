package com.mph.trade;


import com.mph.book.BuySell;


import java.io.IOException;


public class ExchangeMain {
    public static void main(String[] args) throws IOException {
        ExchangeMain.showOptions();

        MiniExchange ex = new MiniExchange();
        String result = ex.registerTrader(new Trader("priya","97898","addr1"));
        String result2 = ex.registerTrader(new Trader("ajay","97910","addr2"));
        ex.registerTrader(new Trader("puja","1234","addr3"));
        System.out.println(result);
        System.out.println(result2);
        System.out.println(ex.getAllTraders());
        System.out.println(ex.updateTrader(new Trader("priya","8765","addr2","97898")));


       ex.placeOrder(new Order("3472","14",13,4,2, BuySell.SELL ));




    }

    public static void showOptions() throws IOException {


    }






}
