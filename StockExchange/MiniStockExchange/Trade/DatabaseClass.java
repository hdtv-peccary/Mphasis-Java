package com.mph.trade;

import java.util.HashMap;
import java.util.Map;


public class DatabaseClass {
    private static Map<String, Trader> traders=new HashMap<>();

    public static Map<String ,Trader> getTraders()
    {
        return traders;
    }

    private static Map<String, Order> orders=new HashMap<>();

    public static Map<String ,Order> getOrders()
    {
        return orders;
    }
}
