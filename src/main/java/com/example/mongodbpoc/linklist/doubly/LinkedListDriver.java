package com.example.mongodbpoc.linklist.doubly;

public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(30);
        linkedList.addFirst(50);
        linkedList.addFirst(60);
        linkedList.addFirst(70);
        linkedList.addFirst(80);
        linkedList.addMid(40, 1);
        linkedList.addLast(100);
        linkedList.display();
        linkedList.deleteMid(2);
        linkedList.display();

    }
}
