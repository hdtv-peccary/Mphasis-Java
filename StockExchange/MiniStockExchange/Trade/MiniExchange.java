package com.mph.trade;



import com.mph.book.BuySell;
import com.mph.book.Market;
import com.mph.book.MarketListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class MiniExchange implements Exchange {

    Map<String, Trader> trader=DatabaseClass.getTraders();
    static Map<String, Order> orderMap=DatabaseClass.getOrders();
    long traderid = 100;
    long orderId =100;
    Market market;
    ExecutorService executor=null;

    public MiniExchange() {
            trader.put("1", new Trader("raji","9789821","addr1","9765"));
            trader.put("2",new Trader("ajay","3235532","addr 2","6574"));
            trader.put("3",new Trader("puja","3435231","addr3","9898"));

        orderMap.put("1", new Order("97899T",12,2,4, BuySell.SELL ));
        orderMap.put("1", new Order("9678T",3,2,3, BuySell.BUY ));
        orderMap.put("1", new Order("96574T",4,2,3, BuySell.SELL ));
          market = new Market();
    }

    public void validate(Order order){

    }

    @Override
    public String registerTrader(Trader traders) {
         traderid =1+ Integer.valueOf(traders.getContactno());
         traders.setTraderid(traderid+"2");
            trader.put(traderid+"2",traders);
        System.out.println(traderid+"2");
            return traderid+"2";
        }

    public Trader updateTrader(Trader traders) {
        if(traders.getTraderid()==null)
        {
            return null;
        }
        trader.put(traders.getTraderid(), traders);
        return traders;
    }

    public Trader deleteTrade(String  traderid) {

        return trader.remove(traderid);

    }

    public List<Trader> getAllTraders() {

        return new ArrayList<Trader>(trader.values());
    }


    public Trader getTrader(String Traderid) {

        return trader.get(Traderid);
    }


    @Override
    public void registerMarketListener(MarketListener listner) {

    }

    @Override
    public void placeOrder(Order order) {

        orderId =1+ Integer.parseInt(order.getTraderId());
        order.setOrderId(orderId+"O");
        orderMap.put(orderId+"O",order);
        System.out.println("Order Id: "+orderId+"O");


    }

    public static List<Order> getAllOrders() {

        return new ArrayList<Order>(orderMap.values());
    }



    @Override
    public void deleteOrder(Order order) {

    }

    @Override
    public void modifyOrder(Order order) {

    }

    @Override
    public void viewBook(long stockid) {
        System.out.println(orderMap.get(stockid));
    }

}
