package com.example.mongodbpoc.tree.verticalOrder;

import java.util.*;

public class BinaryTree {
    private Node root = null;

    public void bottomView() {
        Queue<Node> queue = new LinkedList<>();
        root.hd = 0;
        queue.offer(root);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (map.containsKey(temp.hd)) {
                    map.get(temp.hd).add(temp.data);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(temp.data);
                    map.put(temp.hd, list);
                }

                if (temp.left != null) {
                    temp.left.hd = temp.hd - 1;
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    temp.right.hd = temp.hd + 1;
                    queue.offer(temp.right);
                }
            }

        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getValue().get(entry.getValue().size() - 1) + " ");
        }

    }

    public void topView() {
        Queue<Node> queue = new LinkedList<>();
        root.hd = 0;
        queue.offer(root);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (map.containsKey(temp.hd)) {
                    map.get(temp.hd).add(temp.data);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(temp.data);
                    map.put(temp.hd, list);
                }

                if (temp.left != null) {
                    temp.left.hd = temp.hd - 1;
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    temp.right.hd = temp.hd + 1;
                    queue.offer(temp.right);
                }
            }

        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getValue().get(0) + " ");
        }

    }

    public void verticalTraversal() {
        Queue<Node> queue = new LinkedList<>();
        root.hd = 0;
        queue.offer(root);
        HashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (map.containsKey(temp.hd)) {
                    map.get(temp.hd).add(temp.data);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(temp.data);
                    map.put(temp.hd, list);
                }

                if (temp.left != null) {
                    temp.left.hd = temp.hd - 1;
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    temp.right.hd = temp.hd + 1;
                    queue.offer(temp.right);
                }
            }

        }
        System.out.println(map);
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

    public void leftView() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                list.add(temp.data);
                if (temp.left != null)
                    queue.offer(temp.left);

                if (temp.right != null)
                    queue.offer(temp.right);
            } else {

                System.out.println(list.get(0));
                list = new ArrayList<>();
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
    }

    public void rightView() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                list.add(temp.data);
                if (temp.left != null)
                    queue.offer(temp.left);

                if (temp.right != null)
                    queue.offer(temp.right);
            } else {
                System.out.println(list.get(list.size() - 1));
                list = new ArrayList<>();
                if (!queue.isEmpty())
                    queue.offer(null);
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
        binaryTree.rightView();
    }

}
