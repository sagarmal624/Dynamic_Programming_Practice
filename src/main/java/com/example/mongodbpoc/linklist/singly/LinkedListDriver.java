package com.example.mongodbpoc.linklist.singly;

public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addLast(7);
        linkedList.addLast(8);
        linkedList.addLast(9);
//
//        LinkedList linkedList2 = new LinkedList();
//        linkedList2.addLast(2);
//        linkedList2.addLast(5);
//        linkedList2.addLast(5);
//        linkedList2.addLast(8);

        linkedList.reverseKthNode(3);

        linkedList.display();


    }
}
