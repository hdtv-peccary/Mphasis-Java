package com.mph;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"first");
        map.put(2,"second");
        map.put(1,"third"); // the value gets updated as 'third' for the key 1
        map.put(4,"four");

        // System.out.println(map);
        //System.out.println(map.get(2));
        Set<Integer> keys =map.keySet();

        Iterator<Integer> iterator = keys.iterator();

        while(iterator.hasNext()){
             Integer key = iterator.next();
            System.out.println(key+ ":"+ map.get(key));
        }


    }
}
