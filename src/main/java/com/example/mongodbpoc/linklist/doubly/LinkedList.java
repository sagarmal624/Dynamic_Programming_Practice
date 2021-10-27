package com.example.mongodbpoc.linklist.doubly;

public class LinkedList {
    private Node root = null;
    private int size = 0;

    public void deleteFirst() {
        if (root != null) {
            Node temp = root.next;
            temp.prev = null;
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
            if (index == 1)
                deleteFirst();
            else if (index == size) {
                deleteLast();
            } else {
                int counter = 1;
                Node prev = root, temp = root;
                while (temp != null && index <= size) {

                    if (counter == index) {
                       Node next=temp.next;
                       next.prev=prev;
                       prev.next=next;
                        break;
                    }
                    counter++;
                    prev = temp;
                    temp = temp.next;
                }
                size--;
            }
        }
    }

    public void addLast(int data) {
        if (root == null) {
            root = new Node(data);
            size++;
        } else {
            Node temp = root;
            while (temp != null) {
                if (temp.next == null) {
                    Node node = new Node(data);
                    node.prev = temp;
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
            size++;
        }
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

    public void display() {
        if (root != null) {
            Node temp = root;
            System.out.println();
            while (temp != null) {
                System.out.print(temp.getData() + "->");
                temp = temp.getNext();
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
                System.out.print(temp.getData() + "->");
                temp = temp.prev;
            }
        }
    }
}
