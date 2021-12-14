package com.example.mongodbpoc.thread;

import java.util.concurrent.CountDownLatch;

class DevTeam extends Thread {
    private CountDownLatch countDownLatch;

    DevTeam(String name, CountDownLatch countDownLatch) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Team " + Thread.currentThread().getName() + " started working");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("finished task by " + Thread.currentThread().getName());
            countDownLatch.countDown();
        }
    }
}

class QATeam extends Thread {
    QATeam(String name) {
        super(name);
    }
    @Override
    public void run() {
        try {
            System.out.println("Team " + Thread.currentThread().getName() + " started VAlidation");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("finished Validation by " + Thread.currentThread().getName());
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        DevTeam team1 = new DevTeam("BE Team", countDownLatch);
        DevTeam team2 = new DevTeam("FE Team", countDownLatch);
        team1.start();
        team2.start();
        countDownLatch.await();
        QATeam qaTeam = new QATeam("QA Team");
        qaTeam.start();
    }
}
