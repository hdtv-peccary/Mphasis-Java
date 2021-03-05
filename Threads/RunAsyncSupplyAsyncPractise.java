package com.mph;

import java.util.concurrent.*;
import java.util.function.Supplier;

//CompletableFuture executes these tasks in a thread obtained from the global ForkJoinPool.commonPool().

public class RunAsyncSupplyAsyncPractise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()-> "First");
        CompletableFuture<String> future1 =  future.thenApply((s)->s+" example");
        //.thenAccept((s)-> System.out.println(s));
        System.out.println(future1.get());

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> s1 + s2);
        System.out.println(completableFuture.get());

        CompletableFuture<String> cf = new CompletableFuture<String>();
        //System.out.println(cf.get()); it blocks forever since the future is never completed
        //manually complete the future using below method
        cf.complete("completion string");
        cf.complete("new completion string which will be ignored");
        System.out.println(cf.get());
        //cf.thenAccept((s)-> System.out.println(s));

        //runAsync takes a runnable obj and doesnt return anything
        CompletableFuture<Void> Cfuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("I'll run in a separate thread than the main thread.");
        });
        Cfuture.get();

        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> Cfuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return "Result of the asynchronous computation";
            }
        });

        // Block and get the result of the Future
        String result = Cfuture1.get();
        System.out.println(result);

        CompletableFuture<String> LambdaSupply =
                CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result from supply method represented in lambda";
        }).thenApply((s)-> s+" concat with string");

        LambdaSupply.get();
        LambdaSupply.thenAccept(System.out::println);

        //creating our own threadPool and passing the supplier and executor to one of the completableFuture variant

        Executor executor = Executors.newFixedThreadPool(10);
        //CompletableFuture<Void> cfe =
                CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("executed by thread from fixed thread pool");
        }, executor).thenAccept(System.out::println);

        //cfe.get();


    }


}
