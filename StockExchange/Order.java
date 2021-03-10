package com.mph;

public class Order implements Comparable<Order> {

    private long quantity;
    private double price;
    private long orderId;
    private OrderType orderType;
    private long stockId;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public Order(long quantity, double price, long orderId, OrderType orderType, long stockId) {
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.orderType = orderType;
        this.stockId = stockId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", orderId=" + orderId +
                ", orderType=" + orderType +
                ", stockId=" + stockId +
                '}';
    }

    @Override
    public int compareTo(final Order o) {

        if (Double.compare(this.getPrice(), o.getPrice()) == 0) {
                return -1;
            } else if(this.getPrice()>o.getPrice()){
                return 1;
            }
        else {
            return Double.compare(this.getPrice(), o.getPrice());
        }
    }

}