package com.example.mongodbpoc.thread;

public class Number {
    public void odd(int num) {
        synchronized (this) {
            for (int i = 1; i <= num; i++) {
                try {
                    if (i % 2 != 0) {
                        System.out.println(i);
                    }
                    notify();
                    wait();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    public void event(int num) {
        synchronized (this) {

            for (int i = 1; i <= num; i++) {

                try {
                    if (i % 2 == 0) {
                        System.out.println(i);

                    }
                    wait();
                    notify();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
}


