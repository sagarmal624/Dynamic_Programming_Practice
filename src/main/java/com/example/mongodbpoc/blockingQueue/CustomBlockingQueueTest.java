package com.example.mongodbpoc.blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueTest {
    int size;
    final Queue<Object> queue;
    final Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public CustomBlockingQueueTest(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public void put(Object x) {
        lock.lock();
        try {
            while (queue.size() == size) {
                condition1.await();
            }
            queue.add(x);
            condition2.signal();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition2.await();
            }
            Object obj = queue.remove();
            condition1.signal();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
