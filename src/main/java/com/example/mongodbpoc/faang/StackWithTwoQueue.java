package com.example.mongodbpoc.faang;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int data) {
        if (q1.isEmpty()) {
            q2.offer(data);
        } else {
            q1.offer(data);
        }
    }

    public int pop() {
        if (q2.isEmpty()) {
            int size = q1.size();
            int i = 0;
            while (i < size - 1) {
                q2.offer(q1.poll());
                i++;
            }
            return q1.poll();
        } else {
            int size = q2.size();
            int i = 0;
            while (i < size - 1) {
                q1.offer(q2.poll());
                i++;
            }
            return q2.poll();
        }

    }

    public static void main(String[] args) {
        StackWithTwoQueue stack = new StackWithTwoQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());

    }
}
