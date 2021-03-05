package com.mph;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// Executor Service manages the thread creation, life cycle and task submission/execution
public class SingleThreadPoolPractise {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("creating executor service with single thread");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //single worker thread is created
        //when thread is busy in another task, new task waits in queue , until the thread is free to execute it
        System.out.println("creating runnable");
        Runnable runnable = ()-> System.out.println(Thread.currentThread().getName());
        System.out.println("submitting the runnable obj task");




        executor.submit(runnable);
            // overloaded submit method of executorservice interface can take any runnable/callable obj


        System.out.println("shutdown the executor");
        //The program never exits, executor keeps listening for new task until we shut it down explicitly
        executor.shutdown();//does not accept new task, waits for submitted tasks to execute and then terminates executor
        //executor.shutdownNow();// interrupts the running task and shutsdown executor immediately


    }
}
