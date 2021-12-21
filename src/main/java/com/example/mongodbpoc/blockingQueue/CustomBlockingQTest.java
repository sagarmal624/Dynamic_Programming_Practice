package com.example.mongodbpoc.blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQTest {
    Lock lock = new ReentrantLock();
    final Condition produceCond = lock.newCondition();
    final Condition consumeCond = lock.newCondition();
    Queue<String> queue = null;
    int count = 0;
    int capacity;

    public CustomBlockingQTest(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void add(String str) {
        lock.lock();
        try {
            while (count == capacity) {
                produceCond.await();
            }
            queue.offer(str);
            count++;
            consumeCond.signal();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (count == 0) {
                consumeCond.wait();
            }
            queue.remove();
            count--;
            produceCond.signal();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
