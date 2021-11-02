package com.example.mongodbpoc.thread;

public class NumberDemo {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread() {
            public void run() {
                number.event(10);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                number.odd(10);
            }
        };
        t1.start();
        t2.start();
    }
}
