package com.example.mongodbpoc.linklist.circular;

public class LinkedList {
    private Node root = null;
    private int size = 0;

    public void deleteFirst() {
        if (root != null) {
            Node temp = root.next;
            root = temp;
            size--;

        }
    }

    public void deleteLast() {
        if (root != null) {
            Node prev = root, temp = root;
            while (temp != null) {

                if (temp.next == null) {
                    prev.next = null;
                    temp = null;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            size--;

        }
    }

    public void deleteMid(int index) {
        if (root != null) {
            int counter = 1;
            Node prev = root, temp = root;
            while (temp != null && index <= size) {

                if (counter == index) {
                    prev.next = temp.next;

                    break;
                }
                counter++;
                prev = temp;
                temp = temp.next;
            }
            size--;

        }
    }

    public void addLast(int data) {
        if (root == null) {
            root = new Node(data);
            root.next = root;
            size++;
        } else {
            Node temp = root;
            while (true) {
                if (temp.next == root) {
                    temp.next = new Node(data);
                    temp.next.next = root;
                    break;
                }
                temp = temp.next;
            }
            size++;
        }
    }

    public int size() {
        int counter = 0;
        if (root != null) {
            Node temp = root;
            System.out.println();
            while (temp.next != root) {
                counter++;
                temp = temp.getNext();
            }
            return counter + 1;

        }
        return counter;
    }


    public void display() {
        if (root != null) {
            Node temp = root;
            System.out.println();
            while (temp.next != root) {
                System.out.print(temp.getData() + "->");
                temp = temp.getNext();
            }
            System.out.print(temp.getData());
        }
    }
}
