package com.mph;

interface  Printer1{
    public void print(String str,Integer i);
}

class Task{
    public int perform(Printer1 p){
        p.print("mph",23);
        return 0;
    }
}
public class PrinterParamEx {
    public static void main(String[] args) {
        String text1 = "newText";
        //Printer1 printer =(text,i)-> System.out.println(text+" "+ i);
        //printer.print("mph",23);
        Task task = new Task();
        task.perform((text, i) -> System.out.println(text + " " + i));
        //Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread()));
        //thread1.start();
        // Printer1 printer = (text) -> System.out.println(text);
        // same step executed in diff way below
//       Printer1 printer =System.out::println;
//        it takes any suitable println methods (above line can be used with single parameter)
//         printer.print(text1);
//         printer= Integer::valueOf;
//         printer.print("23");

    }
}
