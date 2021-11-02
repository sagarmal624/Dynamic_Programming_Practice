package com.example.mongodbpoc.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node root = null;

    public int maxSuminLevel() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int currentSum = 0, maxSum = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                currentSum = currentSum + temp.data;
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            } else {

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                currentSum = 0;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }

        }
        return maxSum;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                Node temp = q.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        q.offer(temp.left);
                    } else {
                        temp.left = new Node(data);
                        break;
                    }
                    if (temp.right != null) {
                        q.offer(temp.right);
                    } else {
                        temp.right = new Node(data);
                        break;
                    }
                }
            }
        }
    }

    public int size(Node root) {
        if (root == null)
            return 0;
        int left = root.left == null ? 0 : size(root.left);
        int right = root.right == null ? 0 : size(root.right);
        return 1 + left + right;
    }

    public void inorder(Node root) {
        if (root != null) {
            preorder(root.left);
            System.out.print(root.data + " ");
            preorder(root.right);
        }
    }

    public void recursiveInOrder() {
        Stack<Node> stack = new Stack<>();
        boolean isDone = false;
        Node temp = root;
        while (!isDone) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.isEmpty()) {
                    isDone = true;
                } else {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    temp = temp.right;
                }
            }
        }

    }

    public int max() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                max = Math.max(max, temp.data);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
        }
        return max;
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void recursivePreOrder() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null)
                stack.push(temp.left);
        }

    }

    public void LeverlwiseReverse() {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null)
                    queue.offer(temp.right);
                stack.push(temp);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    public int height(Node root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);
        if (left > right)
            return left + 1;
        return right + 1;
    }

    public int numOfLeaves() {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        int counter = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left == null && temp.right == null)
                    counter++;
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
        }
        return counter;
    }

    public boolean isSame(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null)
            return true;
        if ((tree1 == null || tree2 == null))
            return false;
        return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
    }

    public int heightIterative() {
        if (root == null)
            return 0;
        int counter = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left == null && temp.right == null)
                    return counter;
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);


            } else {
                if (!queue.isEmpty()) {
                    counter++;
                    queue.offer(null);
                }
            }
        }
        return counter;
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

        System.out.println("sum");
        System.out.println(binaryTree.maxSuminLevel());

    }

    public static BinaryTree getTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(11);
        binaryTree.root.left.left = new Node(7);
        binaryTree.root.right = new Node(9);
        binaryTree.root.right.left = new Node(15);
        binaryTree.root.right.right = new Node(8);
        return binaryTree;
    }
}
