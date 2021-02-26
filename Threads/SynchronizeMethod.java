package com.mph;


class Data1
{
    private int value;

    public synchronized void getValue() {
        System.out.println(value);
        try {
            notify();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public  synchronized void setValue(int value) {
        this.value = value;
        try {
            notify();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Runs1 implements Runnable{
    Data1 data;
    Runs1(){
        data = new Data1();
    }

    @Override
    public void run() {
        Thread currThread = Thread.currentThread();

        for(int counter =0;counter<10;counter++){
            System.out.println(currThread);
            if(currThread.getName().equalsIgnoreCase("Producer")){

                    data.setValue(counter + 1);

                }

            else {

                    data.getValue();

                }
            }
        }

    }

public class SynchronizeMethod{
    public static void main(String[]args){
        Thread mainthread = Thread.currentThread();
        Runs r = new Runs();
        Thread t1 = new Thread(r,"Producer");
        Thread t2 = new Thread(r,"Consumer");
        t1.start();
        t2.start();
        System.out.println("end");

    }
}


