package com.example.mongodbpoc.tree;

public class Node {
    public int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
