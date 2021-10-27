package com.example.mongodbpoc.linklist.singly;

public class Node {
    Integer data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
