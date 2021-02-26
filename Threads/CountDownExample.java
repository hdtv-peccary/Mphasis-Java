package com.mph;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Task implements Runnable{

    CountDownLatch latch;

    public Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run()  {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println("Progress...");


    }
}
public class CountDownExample {
    public static void main(String[] args) throws InterruptedException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        CountDownLatch latch = new CountDownLatch(3);

        service.submit(new Task(latch));
        service.submit(new Task(latch));
        service.submit(new Task(latch));

        //main thread invoking await method
        latch.await();   //for the main thread to wait for the latches

        System.out.println("initiating shutdown");
        service.shutdown();
        System.out.println("shutdown initiated");

    }

}
