package com.example.mongodbpoc.tree.equaltyChecking;

import com.example.mongodbpoc.tree.Node;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private Node root = null;

    public boolean isSame(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.data == root2.data && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public boolean areMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.data == root2.data && isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
    }

    public Node convertIntoMirror(Node root) {
        if (root == null)
            return root;
        Node left = convertIntoMirror(root.left);
        Node right = convertIntoMirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    boolean isSubtree(Node T, Node S) {

        if (S == null)
            return true;
        if (T == null)
            return false;

        if (isSame(T, S))
            return true;
        return isSubtree(T.left, S)
                || isSubtree(T.right, S);
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

        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.root = new Node(10);
        binaryTree1.root.left = new Node(11);
        binaryTree1.root.left.left = new Node(7);
        binaryTree1.root.right = new Node(9);
        binaryTree1.root.right.left = new Node(15);
        binaryTree1.root.right.right = new Node(8);

        System.out.println(binaryTree.areMirror(binaryTree.root, binaryTree1.root));

    }

}
