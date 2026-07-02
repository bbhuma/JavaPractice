
package com.java.JavaRefresherIntermediate.JavaAdvanced;

import java.util.concurrent.CompletableFuture;

/*
===============================================================================
J42_CompletableFutureMaster

Topics
------
runAsync()
supplyAsync()
thenApply()
thenCompose()
thenCombine()
exceptionally()
allOf()
===============================================================================
*/
public class J42_CompletableFutureMaster {

    public static void main(String[] args) throws Exception {

        CompletableFuture<Void> run =
                CompletableFuture.runAsync(
                        () -> System.out.println("Background Task"));

        run.join();

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(x -> x * 2)
                        .thenApply(x -> x + 5);

        System.out.println(future.get());

        CompletableFuture<String> first =
                CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> second =
                CompletableFuture.supplyAsync(() -> " Java");

        CompletableFuture<String> combined =
                first.thenCombine(second, String::concat);

        System.out.println(combined.get());

        CompletableFuture<Integer> compose =
                CompletableFuture.supplyAsync(() -> 5)
                        .thenCompose(x ->
                                CompletableFuture.supplyAsync(() -> x * 100));

        System.out.println(compose.get());

        CompletableFuture<Object> error =
                CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException();
                }).exceptionally(ex -> -1);

        System.out.println(error.get());

        CompletableFuture.allOf(first, second).join();

        /*
        Interview Memory

        runAsync()      -> no return
        supplyAsync()   -> returns value
        thenApply()     -> transform
        thenCompose()   -> flatten async
        thenCombine()   -> combine two futures
        exceptionally() -> error handling
        */
    }
}
