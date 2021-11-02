package com.example.mongodbpoc.thread;

public class Demo {
    public static void main(String[] args) {
     Thread.currentThread().getThreadGroup().getParent().list();

    }
}
