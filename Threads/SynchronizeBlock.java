package com.mph;

import java.util.concurrent.TimeUnit;

class Data
    {
        private int value;

        public  void getValue() {
            System.out.println(value);
        }

        public  void setValue(int value) {
            this.value = value;
        }
    }

    class Runs implements Runnable{
        Data data;
        private volatile boolean exit = false;
        Runs(){
            data = new Data();
        }
        @Override
        public void run() {

            Thread currThread = Thread.currentThread();

            for(int counter =0;counter<10;counter++){
                System.out.println(currThread);
                if(currThread.getName().equalsIgnoreCase("Producer")){
                    synchronized (data) {
                        data.setValue(counter + 1);
                        try {
                             data.notify(); // notifies the consumer that its going to wait pool
                            data.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else {
                    synchronized (data) {
                        data.getValue();
                       try {
                            data.notify();
                            data.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();}
                    }
                }
            }

        }
}
    public class SynchronizeBlock {
        public static void main(String[]args)  {
            Thread mainthread = Thread.currentThread();
            Runs r = new Runs();
            Thread t1 = new Thread(r,"Producer");
            Thread t2 = new Thread(r,"Consumer");
            t1.start();
            t2.start();
            System.out.println("end");

        }
    }


