package com.example.mongodbpoc.thread;

import java.util.concurrent.CyclicBarrier;

class Traveler extends Thread {
    CyclicBarrier cyclicBarrier;
    long duration;

    Traveler(long duration, String name, CyclicBarrier cyclicBarrier) {
        super(name);
        this.duration = duration;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " Arrived");
            int count = cyclicBarrier.await();
            if (count == 0) {
                System.out.println("Cab is going to start now");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public class CyclicBarrierDemo {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        Traveler traveler1 = new Traveler(1000, "Sagar", cyclicBarrier);
        Traveler traveler2 = new Traveler(2000, "Rahul", cyclicBarrier);
        Traveler traveler3 = new Traveler(1600, "Ankita", cyclicBarrier);
        Traveler traveler4 = new Traveler(5000, "Mamta", cyclicBarrier);
        Traveler traveler5 = new Traveler(500, "Shyam", cyclicBarrier);
        Traveler traveler6 = new Traveler(3000, "Rishabh", cyclicBarrier);
        Traveler traveler7 = new Traveler(5000, "Santosh", cyclicBarrier);
        Traveler traveler8 = new Traveler(1600, "Sharda", cyclicBarrier);

        traveler1.start();
        traveler2.start();
        traveler3.start();
        traveler4.start();
        traveler5.start();
        traveler6.start();
        traveler7.start();
        traveler8.start();
    }
}
