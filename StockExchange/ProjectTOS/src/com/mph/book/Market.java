package com.mph.book;

import com.mph.trade.Event;
import com.mph.trade.MiniExchange;
import com.mph.trade.Order;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Market {


    private static final Logger LOGGER = Logger.getLogger("market");
    private OrderBook books;
    private BookOrder orders;
    private MarketListener listener;

    private List<Order> orderList = new ArrayList<Order>();


    public Market() {

    }

    //TODO
    public void registerListener(MarketListener listener) {

    }

    //TODO
    public OrderBook open(long securityId) {
        return null;
    }

    //TODO
    public BookOrder find(long orderId) {
        return null;
    }

    //TODO
    public void add(long instrument, long orderId, BuySell side, long price, long size) {


    }

    //TODO
    public void doMatching(OrderBook book, boolean bbo, long orderId, long size, long price) {

    }

    //TODO
    public void modify(long orderId, long size) {

    }

    //TODO
    public long execute(long orderId, long quantity) {
        return 1L;
    }

    //TODO
    public long execute(long orderId, long quantity, long price) {
        return 1l;
    }

    //TODO
    public void execute(long orderId, BookOrder order, long quantity, long price) {

    }

    public synchronized void execute() {

        this.orderList = MiniExchange.getAllOrders();

        System.out.println("List size from market " + MiniExchange.getAllOrders().size());

        this.orderList
                .stream().filter(o -> o.getSide().equals(BuySell.SELL))
                .forEach(
                        product -> {


                            LOGGER.info("trading stock " + product.stockId); //123
                            List<Order> buyOrderForStock = getBuyOrdersForStock(product.getStockId());
                            if (buyOrderForStock.size() == 0) {
                                LOGGER.info("no buyers interested in stock "
                                        + product.stockId
                                );
                            } else {

                                Optional<Order> tradedOrder = buyOrderForStock.stream().filter(
                                        ord -> {
                                            return ord.getQty() <= product.getQty();

                                        }
                                ).sorted(Comparator.comparingLong(Order::getPrice)).findFirst();

                                System.out.println("traded order " + tradedOrder);
                                if (!tradedOrder.isPresent()) {
                                    System.out.println("no trade happened");
                                } else {
                                    LOGGER.info("traded buy order " + tradedOrder.get());
                                    String BuyOrderId = tradedOrder.get().orderId;
                                    String sellerOrderId = product.orderId;
                                    product.setQty(product.getQty() - tradedOrder.get().qty);
                                    if (product.getQty() == 0) {
                                        MiniExchange.deleteOrder(sellerOrderId);
                                    }
                                    System.out.println("product sell order " + product);
                                    MiniExchange.deleteOrder(BuyOrderId);

                                    LOGGER.info("traded order removed from orderList");

                                }
                            }
                        });


        System.out.println("executed");

    }


    public List<Order> getBuyOrdersForStock(long stockId) {

        return this.orderList.stream().filter(e -> {

            return ((e.getStockId() == stockId) && e.getSide().equals(BuySell.BUY));

        }).collect(Collectors.toList());
    }


    //TODO
    public long cancel(Event event) {
        return 1l;
    }


    //TODO
    public void delete(long orderId) {

    }

    //TODO
    public void modify(Event event) {
    }
}
