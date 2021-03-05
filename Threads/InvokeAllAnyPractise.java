package com.mph;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllAnyPractise {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task1 = ()->{Thread.sleep(2000);
                                       return "executing task1";};
        Callable<String> task2 = ()->{Thread.sleep(1000);
                                       return "executing task2";};
        Callable<String> task3 = ()->{Thread.sleep(5000);
                                       return "executing task3";};


        List<Callable<String>> CallList = Arrays.asList(task1,task2,task3);
        List<Future<String>> futureList = executorService.invokeAll(CallList);
        //invokeAll returns the list of futures
        for(Future<String> f: futureList){
            String result = f.get(); // get method blocks until all the futures are complete (for 5 seconds)
            System.out.println(result);
        }

        String result = executorService.invokeAny(CallList);
        //invokeAny method returns the result of the fastest callable task and not the future
        System.out.println(result);
        executorService.shutdown();
    }
}