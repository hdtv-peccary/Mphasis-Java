package com.company;

import java.util.concurrent.*;

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

class Task implements Callable<Point>{

    @Override
    public Point call() throws Exception {
        return new Point(2,6);
    }
}
public class CallableExample{
    public static void main(String []args){
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newScheduledThreadPool(coreCount);
        Future<Point> future = service.submit(new Task());
        try {
            Point point = future.get();
            System.out.println(point);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
        service.shutdown();

    }

}
