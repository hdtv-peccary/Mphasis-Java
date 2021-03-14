package com.mph.trade;


import com.mph.book.*;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MiniExchange implements Exchange {

    Map<String, Trader> trader = new HashMap<>();
    static Map<String, Order> orderMap = new HashMap<>();
    long traderid = 100;
    long orderId = 100;
    Market market;
    ExecutorService executor = null;

    public MiniExchange() {
        trader.put("9792", new Trader("raji", "978", "addr1", "9792"));
        trader.put("3262", new Trader("ajay", "325", "addr 2", "3262"));
        trader.put("3472", new Trader("puja", "346", "addr3", "3472"));

        orderMap.put("11", new Order("97899T", "11", 12, 2, 4, BuySell.SELL));
        orderMap.put("12", new Order("9678T", "12", 3, 3, 3, BuySell.BUY));
        orderMap.put("13", new Order("96574T", "13", 3, 4, 3, BuySell.SELL));
        market = new Market();
    }

    public String validate(Order order) throws InvalidTraderException {
        String value = getValidTrader(order.getTraderId());
        return value;
    }

    @Override
    public String registerTrader(Trader traders) {
        traderid = 1 + Integer.valueOf(traders.getContactno());
        traders.setTraderid(traderid + "2");
        trader.put(traderid + "2", traders);
        System.out.println(traderid + "2");
        return traderid + "2";
    }

    public Trader updateTrader(Trader traders) {
        if (traders.getTraderid() == null) {
            return null;
        }
        trader.put(traders.getTraderid(), traders);
        return traders;
    }

    public Trader deleteTrade(String traderid) {

        return trader.remove(traderid);

    }

    public List<Trader> getAllTraders() {

        return new ArrayList<Trader>(trader.values());
    }


    public String getValidTrader(String Traderid) throws InvalidTraderException {
        String msg = "";
        if (trader.get(Traderid) == null) {
            msg = "Invalid Trader";
            throw new InvalidTraderException(msg);
        } else if (trader.get(Traderid).getTraderid().equals(Traderid)) {
            msg = "Valid Trader";
            return msg;
        } else {
            try {
                msg = "Invalid Trader";
                throw new InvalidTraderException(msg);
            } catch (InvalidTraderException e) {
                e.printStackTrace();
            }
        }
        msg = "Invalid Trader";
        return msg;
    }

    public Trader getTrader(String Traderid) {
        return trader.get(Traderid);
    }


    @Override
    public void registerMarketListener(MarketListener listner) {

    }

    @Override
    public void placeOrder(Order order) {
        String validTrader = " ";
        try {
            validTrader = validate(order);
        } catch (InvalidTraderException e) {
            e.printStackTrace();
        }

        if (validTrader.equalsIgnoreCase("valid trader")) {
            orderId = 1 + Integer.parseInt(order.getTraderId());
            order.setOrderId(orderId + "O");
            orderMap.put(orderId + "O", order);
            System.out.println("Order Id: " + orderId + "O");
            System.out.println("Event");
            Event event = new Event();
            event.setRequestType(OrderRequestType.NEW);
            System.out.println("Thread started");
            int coreCount = Runtime.getRuntime().availableProcessors();
            System.out.println(coreCount);
            executor = Executors.newFixedThreadPool(coreCount);

            Runnable worker = new XchangeWorker(event);
            executor.execute(worker);


            executor.shutdown();
            System.out.println("Finished all threads");
        }

    }


    public static List<Order> getAllOrders() {

        return new ArrayList<Order>(orderMap.values());
    }


    //TODO
    @Override
    public void deleteOrder(Order order) {

    }

    public static void deleteOrder(String orderId) {

        orderMap.remove(orderId);
        System.out.println("order list after trade" + orderMap);


    }


    //TODO
    @Override
    public void modifyOrder(Order order) {

    }

    @Override
    public void viewBook(long stockid) {
        System.out.println(orderMap.get(stockid));
    }

}
