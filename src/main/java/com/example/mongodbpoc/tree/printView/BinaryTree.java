package com.example.mongodbpoc.tree.printView;

import com.example.mongodbpoc.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private Node root = null;

    public void insert(int data) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null)
                queue.offer(temp.left);
            else {
                temp.left = new Node(data);
                break;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            } else {
                temp.right = new Node(data);
                break;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(11);
        binaryTree.root.left.left = new Node(7);
        binaryTree.root.right = new Node(9);
        binaryTree.root.right.left = new Node(15);
        binaryTree.root.right.right = new Node(8);
    }

}
