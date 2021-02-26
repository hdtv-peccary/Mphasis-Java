package com.company;

import java.util.ArrayList;
import java.util.List;
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
    String name;
    int c1,c2;

    public Task(String name, int c1, int c2) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public Point call() throws Exception {
        System.out.println(Thread.currentThread()+" "+name);
        return new Point(c1,c2);
    }
}
public class FutureExample {
    public static void main(String []args){
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newScheduledThreadPool(coreCount);
        List<Future> FutureList =new ArrayList<Future>();

        for(int counter =0;counter<10;counter++){
            Future<Point> future = service.submit(new Task("Task"+(counter+1),counter+1,counter+2));
            FutureList.add(future);
        }
        /*System.out.println("initiating shutdown");
        service.shutdown();
        System.out.println(" shutdown initiated");
        Future<Point> fu = service.submit(new Task("task2",1,2));*/
        //u cannot give new task , once the shutdown is initiated
        for(Future<Point> f:FutureList ){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
        //isterminated is to see whether the thread pool is destroyed


    }


}


