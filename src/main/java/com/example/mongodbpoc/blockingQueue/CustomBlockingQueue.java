package com.example.mongodbpoc.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {
    final Lock lock = new ReentrantLock();

    // Conditions
    final Condition produceCond = lock.newCondition();
    final Condition consumeCond = lock.newCondition();

    // Array to store element for CustomBlockingQueue
    final Object[] array = new Object[6];
    int putIndex, takeIndex;
    int count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == array.length) {
                produceCond.await();
            }
            array[putIndex] = x;
            System.out.println("Producing - " + x);
            putIndex++;
            if (putIndex == array.length) {
                putIndex = 0;
            }
            ++count;
            consumeCond.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                consumeCond.await();
            }
            Object x = array[takeIndex];
            System.out.println("Consuming - " + x);
            takeIndex++;
            if (takeIndex == array.length) {
                takeIndex = 0;
            }
            --count;
            produceCond.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
