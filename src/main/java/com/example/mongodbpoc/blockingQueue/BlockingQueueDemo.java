package com.example.mongodbpoc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

public class BlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(6);
        try {

            new Thread(() -> {
                try {
                    queue.take();
                    queue.take();
                    queue.take();
                    queue.take();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
//            Thread.sleep(10000);
            new Thread(() -> {
                queue.add("sagar7");
                queue.add("sagar8");
            }).start();

            new Thread(() -> {
                queue.add("sagar1");
                queue.add("sagar2");
                queue.add("sagar3");
                queue.add("sagar4");
                queue.add("sagar5");
                queue.add("sagar6");
            }).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
