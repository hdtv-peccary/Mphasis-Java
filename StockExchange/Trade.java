package com.mph;


public class Trade {

    private long BuyerOrderId;
    private long SellerOrderId;
    private long quantity;
    private double price;
    private long stockId;

    public long getBuyerOrderId() {
        return BuyerOrderId;
    }

    public void setBuyerOrderId(long buyerOrderId) {
        BuyerOrderId = buyerOrderId;
    }

    public long getSellerOrderId() {
        return SellerOrderId;
    }

    public void setSellerOrderId(long sellerOrderId) {
        SellerOrderId = sellerOrderId;
    }

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

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public Trade(long buyerOrderId, long sellerOrderId, long quantity, double price, long stockId) {
        BuyerOrderId = buyerOrderId;
        SellerOrderId = sellerOrderId;
        this.quantity = quantity;
        this.price = price;
        this.stockId = stockId;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "BuyerOrderId=" + BuyerOrderId +
                ", SellerOrderId=" + SellerOrderId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", stockId=" + stockId +
                '}';
    }
}