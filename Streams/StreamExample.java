package com.mph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        numbers.forEach(element -> System.out.println(element));
//        numbers.forEach(System.out::println);

//        numbers.stream()
//                .map(e-> e * 2)
//                .forEach(System.out::println);

//        numbers.stream()
//                .map(e-> e * 2.0)
//                .forEach(System.out::println);

//        numbers.stream()
//                .map(String::valueOf)
//                .forEach(System.out::println);
//
//        System.out.println(numbers.stream()
//                .reduce(0,(total,e)->Integer.sum(total,e)));
//        System.out.println(numbers.stream()
//                .reduce(0,Integer::sum));
//
//         numbers.stream()
//                 .map(e->String.valueOf(e))
//                 .reduce("",(concatString,str)->concatString.concat(str));
//
//        System.out.println(numbers.stream()
//                            .map(e -> String.valueOf(e))
//                             .reduce("",String::concat));
//        System.out.println(numbers.stream()
//                .mapToInt(e -> Integer.valueOf(e))
//                .sum());
//
//        numbers.stream()
//                .filter(e-> e%2 ==0)
//                .map(e-> e*2)
//                .forEach(System.out::println);
//
//        System.out.println(numbers.stream()
//                .filter(e-> e%2 ==0)
//                .map(e-> e*2)
//                .reduce(0,Integer::sum));
//
//        System.out.println(numbers.stream()
//        .filter(e->e%2==0)
//        .reduce(0,(total,e)->Integer.sum(total,e)));

            List<Integer> dNumbers  = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
            List<Integer> DoubleEven = dNumbers.stream()
                    .filter(e->e%2==0)
                    .map(e->e*2)
                    .collect(Collectors.toList());
        System.out.println(DoubleEven);


                   // .forEach(e->DoubleEven.add(e)); //shared and mutated


    }


}


