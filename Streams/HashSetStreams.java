package com.mph;

import java.util.HashSet;

public class HashSetStreams {
    public static void main(String[] args) {
        HashSet<Integer> hs =new HashSet<Integer>();
        for(int i=0;i<10;i++)
        {
            hs.add(i);
        }


        hs.stream()
                .map(e->e*3)
                .filter(e->e>=20)
                .forEach(System.out::println);

        hs.stream()
                .map(e->e*2)
                .filter(e->e>10)
                .forEach(HashSetStreams::Print);

    }

    public static void Print(int x){
        System.out.println("value is "+x);
    }

}
