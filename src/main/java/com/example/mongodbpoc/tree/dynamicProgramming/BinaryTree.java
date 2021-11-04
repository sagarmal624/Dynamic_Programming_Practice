package com.example.mongodbpoc.tree.dynamicProgramming;

import com.example.mongodbpoc.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root = null;

    public boolean isSumTree(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int left = getSum(root.left);
        int right = getSum(root.right);
        if (left + right == root.data)
            return isSumTree(root.left) && isSumTree(root.right);
        return false;
    }

    public int getSum(Node root) {
        if (root == null)
            return 0;
        if (root != null)
            return root.data;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return leftSum + rightSum;
    }

    public boolean isSibling(Node root, int m, int n) {
        if (root == null)
            return false;
        if (root.left != null && root.right != null) {
            int left = root.left.data;
            int right = root.right.data;
            if (left == m && right == n)
                return true;
            else if (left == n && right == m)
                return true;
        }
        if (root.left != null)
            isSibling(root.left, m, n);
        if (root.right != null)
            isSibling(root.right, m, n);
        return true;
    }

    public Node lowerCommonAnchestor(Node root, int m, int n) {
        if (root == null)
            return null;

        if (root.data == m || root.data == n)
            return root;

        Node left = lowerCommonAnchestor(root.left, m, n);
        Node right = lowerCommonAnchestor(root.right, m, n);
        if (left != null && right != null)
            return root;
        else {
            return left != null ? left : right;
        }
    }

    public int height(Node root) {
        if (root == null)
            return 0;

        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    public int diameter(Node root) {
        if (root == null)
            return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        int leftD = diameter(root.left);
        int rightD = diameter(root.right);
        return Math.max(Math.max(leftH, rightH) + 1, Math.max(leftD, rightD));
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

    public int findLevel(Node root, int a, int level) {
        if (root == null)
            return -1;
        if (root.data == a)
            return level;
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }

    public int distance(Node root, int m, int n) {
        Node lca = lowerCommonAnchestor(root, m, n);
        int d1 = findLevel(lca.left, m, 0);
        int d2 = findLevel(lca.right, n, 0);
        return d1 + d2;
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
        System.out.println(binaryTree.diameter(binaryTree.root));

    }

}
