package com.mph;


import java.util.ArrayList;
import java.util.Collections;


public class OrderBook {

    private ArrayList<Order> buyOrders;
    private ArrayList<Order> sellOrders;
    private double lastSalePrice;

    public OrderBook(ArrayList<Order> buyOrders, ArrayList<Order> sellOrders) {
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
    }

    public synchronized ArrayList<Trade> process(final Order order) {

        if (order.getOrderType() == OrderType.BUY) {
            return this.processLimitBuy(order);
        } else {
            return this.processLimitSell(order);
        }

    }

    private synchronized ArrayList<Trade> processLimitBuy(final Order order) {
        final ArrayList<Trade> trades = new ArrayList<Trade>();

        final int n = this.sellOrders.size();

        if (n != 0) {
            System.out.println("orderbook is not empty");
            System.out.println("checking atleast one matching order");
            if (this.sellOrders.get(n - 1).getPrice() <= order.getPrice()) {

                // Traverse matching orders
                for(int i=0;i<sellOrders.size();i++){
                    final Order sellOrder = this.sellOrders.get(0);
                    System.out.println(sellOrder.toString());
                    if (sellOrder.getPrice() > order.getPrice()) {

                        break;
                    }
                    // Fill entire order.
                    if (sellOrder.getQuantity() >= order.getQuantity()) {
                        System.out.println("fill entire order and add trade");
                        trades.add(
                                new Trade(order.getOrderId(), sellOrder.getOrderId(), order.getQuantity(), sellOrder.getPrice(),order.getStockId()));
                        sellOrder.setQuantity(sellOrder.getQuantity() - order.getQuantity());
                        if (sellOrder.getQuantity() == 0) {

                            this.removeSellOrder(0);
                        }

                        this.setLastSalePrice(sellOrder.getPrice());
                        return trades;
                    }

                    // Fill partial order & continue.
                    if (sellOrder.getQuantity() < order.getQuantity()) {
                        System.out.println("fill partial sellOrder");
                        trades.add(new Trade(order.getOrderId(), sellOrder.getOrderId(), sellOrder.getQuantity(),
                                sellOrder.getPrice(),order.getStockId()));
                        order.setQuantity(order.getQuantity() - sellOrder.getQuantity());

                        this.removeSellOrder(0);
                        this.setLastSalePrice(sellOrder.getPrice());
                        continue;
                    }

                }

            }
        }

        // Add remaining order to book.
        this.buyOrders.add(order);
        System.out.println("sorting the buyorder");
        Collections.sort(this.buyOrders);
        System.out.println("buy order got after sorting"+this.buyOrders);
        return trades;
    }

    private synchronized ArrayList<Trade> processLimitSell(final Order order) {

        final ArrayList<Trade> trades = new ArrayList<Trade>();

        final int n = this.buyOrders.size();

        System.out.println("Check if order book is empty");
        double currentPrice;
        if (n == 0) {
            currentPrice = -1;
        } else {
            currentPrice = this.buyOrders.get(n - 1).getPrice();
        }

        if (n != 0 || currentPrice >= order.getPrice()) {
            System.out.println("currentPrice >= order.getPrice()"+ currentPrice +" >="+ order.getPrice());
            // Traverse all matching orders.
            for (int i = 0; i < buyOrders.size(); i++) {
                final Order buyOrder = this.buyOrders.get(i);

                // Fill entire order.
                if (buyOrder.getQuantity() >= order.getQuantity()) {
                    trades.add(new Trade(order.getOrderId(), buyOrder.getOrderId(), order.getQuantity(), buyOrder.getPrice(),order.getStockId()));
                    buyOrder.setQuantity(buyOrder.getQuantity() - order.getQuantity());
                    if (buyOrder.getQuantity() == 0) {
                        this.removeBuyOrder(i);
                    }
                    this.setLastSalePrice(buyOrder.getPrice());
                    return trades;
                }

                // Fill partial order and continue.
                if (buyOrder.getQuantity() < order.getQuantity()) {
                    trades.add(new Trade(order.getOrderId(), buyOrder.getOrderId(), buyOrder.getQuantity(), buyOrder.getPrice(),order.getStockId()));
                    order.setQuantity(order.getQuantity() - buyOrder.getQuantity());
                    this.removeBuyOrder(i);
                    this.setLastSalePrice(buyOrder.getPrice());
                    continue;
                }

            }

        }
        // Add remaining order to the list.
        this.sellOrders.add(order);

        Collections.sort(this.sellOrders);

        return trades;

    }

    public double getSpread() {

        if (this.buyOrders.size() != 0 && this.sellOrders.size() != 0) {
            final double buyOrderPrice = this.buyOrders.get(this.buyOrders.size() - 1).getPrice();

            final double sellOrderPrice = this.sellOrders.get(0).getPrice();

            return sellOrderPrice - buyOrderPrice;
        }

        return 0;

    }

    private synchronized void removeBuyOrder(final int index) {
        this.buyOrders.remove(index);
    }

    private synchronized void removeSellOrder(final int index) {
        this.sellOrders.remove(index);
    }

    public ArrayList<Order> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(ArrayList<Order> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public ArrayList<Order> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(ArrayList<Order> sellOrders) {
        this.sellOrders = sellOrders;
    }

    public double getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(double lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }
}