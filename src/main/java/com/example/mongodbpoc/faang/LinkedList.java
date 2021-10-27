package com.example.mongodbpoc.faang;


public class LinkedList {
    Node root = null;
    private int size = 0;

    public Node addLast(int data) {
        Node node = new Node(data);

        if (root == null) {
            node = new Node(data);
            root = node;
            size++;
        } else {
            Node temp = root;
            while (temp != null) {
                if (temp.next == null) {

                    node.prev = temp;
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
            size++;
        }
        return node;
    }

    public int size() {
        return size;
    }

    public void addMid(int data, int index) {
        if (root == null) {
            root = new Node(data);
            size++;
        } else {
            int counter = 1;
            if (index == 1)
                addFirst(data);
            else if (index == size)
                addLast(data);
            else {
                Node temp = root;
                if (index <= size) {
                    while (temp != null && index > 1 && counter < size) {
                        if (index == counter) {
                            Node node = new Node(data);
                            node.prev = temp;
                            node.next = temp.next;
                            temp.next.prev = node;
                            temp.next = node;
                            break;
                        }
                        counter++;
                        temp = temp.next;
                    }
                    size++;
                } else {
                    throw new IndexOutOfBoundsException(index + " is not found");
                }
            }
        }
    }

    public void addFirst(int data) {
        if (root == null) {
            root = new Node(data);
            size++;
        } else {
            Node temp = root;
            Node node = new Node(data);
            node.next = temp;
            temp.prev = node;
            root = node;
            size++;
        }
    }

    public void merge() {
        Node current = root;
        while (current != null) {
            if (current.child != null) {
                Node next = current.next;
                Node childStart = current.child;
                current.next = childStart;
                while (childStart != null) {
                    if (childStart.next == null) {
                        childStart.next = next;
                        break;
                    }
                    childStart = childStart.next;
                }
                current.child = null;
                current = current.next;
            } else
                current = current.next;
        }
    }

    public void display() {
        if (root != null) {
            Node temp = root;
            System.out.println();
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
        }
    }

    public void displayReverse() {
        if (root != null) {
            Node temp = root, prev = root;
            System.out.println();
            while (temp != null) {
                prev = temp;
                temp = temp.next;
            }
            temp = prev;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.prev;
            }
        }
    }
}
