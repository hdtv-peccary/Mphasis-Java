package com.mph;

public class MemoryConsistencyErrorPractise {
    private static volatile boolean sayHello = false;
    //private static boolean sayHello = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while(!sayHello) {
            }

            System.out.println("Hello World!");

            while(sayHello) {
            }

            System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println("Say Hello..");
        sayHello = true;

        Thread.sleep(1000);
        System.out.println("Say Bye..");
        sayHello = false;

        // the compiler always reads the volatile variable value from the main thread instead of the temporary registers
    }
}