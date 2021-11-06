package com.example.mongodbpoc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws Exception {
        List<Callable<String>> task = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {

            executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();

    }
}
