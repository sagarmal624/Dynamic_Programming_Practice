package com.example.mongodbpoc.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue {
    Lock lock = new ReentrantLock();
    Condition cond1 = lock.newCondition();
    Condition cond2 = lock.newCondition();
    Queue<Integer> queue = null;
    int size;

    public ArrayBlockingQueue(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public void put(int data) throws InterruptedException {
        lock.lock();
        try {
            if (size == queue.size()) {
                cond1.await();
            }
            queue.offer(data);
            cond2.signal();
        } finally {
            lock.unlock();
        }
    }


    public void take() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                cond2.await();
            }
            queue.poll();
            cond1.signal();
        } finally {
            lock.unlock();
        }
    }
}
