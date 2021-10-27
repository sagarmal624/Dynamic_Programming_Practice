package com.example.mongodbpoc.linklist.singly;

public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(15);
        linkedList.addLast(3);
        linkedList.addLast(5);
        linkedList.addLast(7);
        linkedList.addLast(9);
        linkedList.addLast(11);
        linkedList.addLast(12);
//
//        LinkedList linkedList2 = new LinkedList();
//        linkedList2.addLast(2);
//        linkedList2.addLast(5);
//        linkedList2.addLast(5);
//        linkedList2.addLast(8);

       linkedList.reverseBetween(3,6);

        linkedList.display();


    }
}
