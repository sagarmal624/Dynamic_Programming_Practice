package com.example.mongodbpoc.tree.verticalOrder;

public class Node {
    public int hd;
    public Integer data;
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
