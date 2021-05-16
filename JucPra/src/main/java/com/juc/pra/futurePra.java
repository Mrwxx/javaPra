package com.juc.pra;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Mr.wxx
 * @create 2021-05-06-14:05
 **/
public class futurePra {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("1111");
        System.out.println(future.get());
    }
}
