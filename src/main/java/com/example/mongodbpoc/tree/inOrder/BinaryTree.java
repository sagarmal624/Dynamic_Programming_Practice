package com.example.mongodbpoc.tree.inOrder;

import com.example.mongodbpoc.tree.Node;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private Node root = null;

    Stack<Integer> stack = new Stack<>();
    static int max = Integer.MIN_VALUE;

    public void maxSumPathsFromRootToLeaf(Node root) {
        if (root != null) {
            stack.push(root.data);
            maxSumPathsFromRootToLeaf(root.left);
            if (root.left == null && root.right == null) {
                System.out.println();
                ListIterator<Integer> integerListIterator = stack.listIterator();
                int sum = 0;
                while (integerListIterator.hasNext()) {
                    sum = sum + integerListIterator.next();
                }
                max = Math.max(max, sum);
            }
            maxSumPathsFromRootToLeaf(root.right);
            stack.pop();
        }

    }

    public void printAllPathsFromRootToLeaf(Node root) {
        if (root != null) {
            stack.push(root.data);
            printAllPathsFromRootToLeaf(root.left);
            if (root.left == null && root.right == null) {
                System.out.println();
                ListIterator<Integer> integerListIterator = stack.listIterator();
                while (integerListIterator.hasNext()) {
                    System.out.print(integerListIterator.next() + " ");
                }
            }
            printAllPathsFromRootToLeaf(root.right);
            stack.pop();
        }

    }

    public void inOrder(Node root) {
        if (root != null) {

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

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
        binaryTree.insert(12);
        binaryTree.maxSumPathsFromRootToLeaf(binaryTree.root);
        System.out.println(max);
    }

}
