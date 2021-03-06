package com.wy.grammar;


import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Runnable target = ()-> System.out.println(Thread.currentThread().getName()+"run method");
        Callable target1 = ()-> 1;
        Future result1 = threadPool.submit(target);
        Future result2 = threadPool.submit(target1);

        if (!result1.isDone()){
            System.out.println("done");
        }
        System.out.println(result2.get());
        threadPool.shutdown();

        CompletableFuture<Void> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "").exceptionally(ex->{ex.printStackTrace();
        return "";}).thenRun(()-> System.out.println("null"));

        stringCompletableFuture.join();
    }
}
