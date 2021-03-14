package com.mph.trade;

import java.io.Serializable;

public class Trader implements Serializable {

    private String tradename;
    private String contactno;
    private String address;
    private String Traderid;

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Trader(String tradename, String contactno, String address) {
        this.tradename = tradename;
        this.contactno = contactno;
        this.address = address;
    }

    public Trader(String tradename, String contactno, String address, String traderid) {
        this.tradename = tradename;
        this.contactno = contactno;
        this.address = address;
        Traderid = traderid;
    }

    public String getTraderid() {
        return Traderid;
    }

    public void setTraderid(String traderid) {
        Traderid = traderid;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "tradename='" + tradename + '\'' +
                ", contactno='" + contactno + '\'' +
                ", address='" + address + '\'' +
                ", Traderid='" + Traderid + '\'' +
                '}';
    }
}
