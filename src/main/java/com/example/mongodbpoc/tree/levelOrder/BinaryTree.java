package com.example.mongodbpoc.tree.levelOrder;

import com.example.mongodbpoc.tree.Node;

import java.util.*;

public class BinaryTree {
    private Node root = null;

    public void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } else {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

    }

    public void findMax() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                max = Math.max(max, temp.data);
            }
        }
        System.out.println(max);
    }

    public void widthOfBinaryTree() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int width = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                list.add(temp.data);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

            } else {
                width = Math.max(width, list.size());
                list = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }

        }
        System.out.println(width);
    }

    public void find(int data) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        boolean isFlag = false;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                if (data == temp.data) {
                    isFlag = true;
                    break;
                }
            }
        }
        System.out.println(isFlag ? "Found" : "Not Found");
    }

    public void findMin() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                min = Math.min(min, temp.data);
            }
        }
        System.out.println(min);
    }

    public void deepestNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null)
                queue.offer(temp.right);
        }
        System.out.println(temp);
    }

    public void heightIterative() {
        int height = 0;
        if (root == null) {
            height = 0;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Node temp = queue.poll();
                    if (temp.left != null)
                        queue.offer(temp.left);
                    if (temp.right != null)
                        queue.offer(temp.right);
                }
                height++;
            }
        }
        System.out.println(height);
    }

    public void size() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int counter = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                counter++;
            }
        }
        System.out.println(counter);
    }

    public void reverseLevelOrderTraversalFromRight() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                stack.push(temp.data);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public void findLevelHasMaxSum() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int max = Integer.MIN_VALUE;
        int maxLevel = 1, sum = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                sum = sum + temp.data;

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } else {
                if (sum > max) {
                    max = sum;
                    maxLevel = level;
                }
                level++;
                sum = 0;
                max = Integer.MIN_VALUE;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        System.out.println(maxLevel);
    }

    public void numberOfFullNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int counter = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null && temp.right != null) {
                counter++;
            }
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        System.out.println(counter);
    }

    public void numberOfLeaves() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int counter = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left == null && temp.right == null) {
                counter++;
            }
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        System.out.println(counter);
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
//        binaryTree.root.left.left.left = new Node(90);
      //  binaryTree.insert(12);
        binaryTree.reverseLevelOrderTraversalFromRight();
    }

}
