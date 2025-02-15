package com.mph;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PointClass{
    int x,y;

    public PointClass(int x, int y) {
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

class TaskClass implements Runnable{

    CyclicBarrier barrier;

    public TaskClass(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run()  {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Progress...");


    }
}
public class BarrierExample {
    public static void main(String[] args) throws InterruptedException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        CyclicBarrier barrier = new CyclicBarrier(3);

        service.submit(new TaskClass(barrier));
        service.submit(new TaskClass(barrier));
        service.submit(new TaskClass(barrier));

        System.out.println("initiating shutdown");
        service.shutdown();
        System.out.println("shutdown initiated");

    }

}



