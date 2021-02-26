package com.mph;

import java.util.Hashtable;
import java.util.Vector;

public class Collect {
    public static void main(String [] args)throws Exception{
        int arr[] =new int [] { 2, 3, 4, 5};
        Vector<Integer> v = new Vector<>();
        Hashtable<Integer,String> h = new Hashtable<>();
        System.out.println(arr[1]);
        v.addElement(4);
        v.addElement(3);
        h.put(1,"go");
        h.put(4,"get");
        System.out.println(h.get(1));

            System.out.println(v.elementAt(1));
    }
}
