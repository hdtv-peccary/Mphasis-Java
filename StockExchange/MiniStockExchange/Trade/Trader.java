package com.mph.trade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Trader {
    private static final Logger LOGGER = Logger.getLogger(Trader.class.getName());

    private String traderId;
    private String traderName;
    private String contactNumber;
    private String address;

    private List<Trader> traderList = new ArrayList<>();

    @Override
    public String toString() {
        return "Trader{" +
                "traderId='" + traderId + '\'' +
                ", traderName='" + traderName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void addTrader(Trader trader){
        this.traderList.add(trader);
    }

    public void deleteTrader(Trader trader){

        this.traderList =this.traderList.stream()
                .filter(tr -> tr.gettraderId()!= trader.gettraderId()).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trader trader = (Trader) o;
        return Objects.equals(traderId, trader.traderId) && Objects.equals(traderName, trader.traderName) && Objects.equals(contactNumber, trader.contactNumber) && Objects.equals(address, trader.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traderId, traderName, contactNumber, address);
    }

    public Trader(String traderId, String traderName, String contactNumber, String address) {
        this.traderId = traderId;
        this.traderName = traderName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String gettraderId() {
        return traderId;
    }

    public void settraderId(String traderId) {
        this.traderId = traderId;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
