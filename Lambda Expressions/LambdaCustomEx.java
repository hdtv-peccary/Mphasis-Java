package com.mph;


interface Printer{
    void print(); // by default its public
}
public class LambdaCustomEx {
    public static void main(String[] args) {
//       Printer printer = new Printer(){
//            @Override
//            public void print() {
//                System.out.println("printed");
//            }
//
//        };
//       printer.print();

        Printer printer = () ->
                System.out.println("printed");
        printer.print();

//        new Thread(()->
//                System.out.println("hi")).start();
    }
}
