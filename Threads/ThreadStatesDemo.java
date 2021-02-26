package com.mph;

class Runner implements Runnable{
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread());
        }

    }


}
public class ThreadStatesDemo {
    public static void main(String []args) {
        Thread mainThread = Thread.currentThread();
        Thread th1 = new Thread(new Runner());
        System.out.println(th1.getState());
        th1.start();
        System.out.println(th1.getState());
        System.out.println("End");
        System.out.println(th1.getState());
    }


}
