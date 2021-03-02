package com.mph;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx {

    public static int compute(){
        //task executed by a thread in fork join pool
        System.out.println("Inside compute : " + Thread.currentThread());
        return 2;
    }

    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(()->compute());
        //return  CompletableFuture.supplyAsync(CompletableFutureEx::compute);

    }

    public static CompletableFuture<Integer> create(int number){
        return CompletableFuture.supplyAsync(()->number);
        

    }

    public static void print(int data){
        System.out.println("Inside print : " + Thread.currentThread());
        System.out.println(data);
    }


    public static void main(String[] args) {
        //create().thenAccept(value-> System.out.println(value));
        //create().thenAccept(value->print(value));
        //value obtained from compute is passed to print

//        create().thenAccept(value -> print(value)).
//                thenRun(() -> System.out.println("1"))
//                .thenRun(() -> System.out.println("2"))
//                .thenRun(() -> System.out.println("3"));

//        CompletableFuture<Integer> cf =new CompletableFuture<>();
//
//        process(cf);
//        cf.complete(5);
          create(3).thenCombine(create(4),(result1,result2)->result1+result2)
          .thenAccept(SumResult-> System.out.println(SumResult));


        System.out.println("End"); //in Future it cannot be done since the main thread would be blocked
    }

    private static void process(CompletableFuture<Integer> cf) {
        cf
                .thenApply(value->value/0)
                .exceptionally(throwable -> handle(throwable))
                .thenApply(value->value+1)
                .thenAccept(result-> System.out.println(result));

//                .thenApply(value->value*2)
//                .thenAccept(result-> System.out.println(result));
//        //value 5 is passed and 5*2 _10 stored in result
    }

    private static int handle(Throwable throwable){
        System.out.println("ERROR: "+throwable);
        //throw new RuntimeException(); u can prefer to rethrow an exception
        return 1;//it replaces the result value
    }



}

//same thread can perform multiple task in completable future
// output :
//     Inside compute : Thread[ForkJoinPool.commonPool-worker-1,5,main]
//     Inside print : Thread[ForkJoinPool.commonPool-worker-1,5,main]
//        2
//
//        Process finished with exit code 0
