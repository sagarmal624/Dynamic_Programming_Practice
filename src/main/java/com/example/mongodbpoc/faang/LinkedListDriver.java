package com.example.mongodbpoc.faang;

public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList child2 = new LinkedList();
        child2.addLast(11);
        child2.addLast(12);


        LinkedList child1 = new LinkedList();
        child1.addLast(7);
        Node node = child1.addLast(8);
        node.child = child2.root;
        child1.addLast(9);
        child1.addLast(10);


        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        node = linkedList.addLast(3);
        node.child = child1.root;
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);

        linkedList.merge();
        linkedList.display();

    }
}
