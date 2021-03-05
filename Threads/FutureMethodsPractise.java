package com.mph;

import java.util.concurrent.*;

public class FutureMethodsPractise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


                ExecutorService executorService = Executors.newSingleThreadExecutor();

                long startTime = System.nanoTime();
                Future<String> future = executorService.submit(() -> { Thread.sleep(2000);
                                                                      return "string from Callable"; }
                                                                      );

                while(!future.isDone()) {
                    System.out.println("Task is still running...");
                    Thread.sleep(200);
                    double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;

                    if(elapsedTimeInSec > 1) {
                        future.cancel(true); //mayInterruptIfRunning is set to true, to cancel the future
                    }
                }
                if(!future.isCancelled()){
                    System.out.println("Task completed! Retrieving the result");
                    String result = future.get();
                   /* future.get(1, TimeUnit.SECONDS);
                    get blocks and waits for the task to complete.
                    It throws a timeout exception if task not completed within specified time*/
                    System.out.println(result);
                }
                else{
                    System.out.println("task is cancelled");
                }


                executorService.shutdown();
            }
        }
