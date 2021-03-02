package com.mph;


interface Printer3{
    public void print(String str);

}

class Task2{
    public int perform(Printer3 printer, String word){
        printer.print(word);
        return 0;
    }
}
public class LambdaOne {
    public static void main(String[] args) {

        Task2 task =new Task2();
        task.perform((text)-> System.out.println(text),"Mphasis");
        task.perform(System.out::println,"Hi");
    }
}
