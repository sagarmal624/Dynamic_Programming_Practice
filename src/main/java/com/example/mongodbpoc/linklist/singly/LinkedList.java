package com.example.mongodbpoc.linklist.singly;

import java.util.PriorityQueue;

public class LinkedList {
    Node root = null;
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
            size++;
        } else {
            Node temp = root;
            while (temp != null) {
                if (temp.next == null) {
                    temp.next = new Node(data);
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
            Node temp = root;
            if (index <= size) {
                while (temp != null && index >= 1) {
                    if (index == counter) {
                        Node next = temp.next;
                        temp.next = new Node(data);
                        temp.next.next = next;
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

    public void reverseBetween(int m, int n) {
        Node current = root, start = null;
        int counter = 1;
        while (counter < m) {
            start = current;
            current = current.next;
            counter++;
        }
        Node tail = current, prev = null;
        while (counter >= m && counter <= n) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            counter++;
        }
        start.next = prev;
        tail.next = current;
        if (m < 1) {
            root = prev;
        }
    }


    public void mergeTwoList(Node head1, Node head2) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();
    }

    public Node sort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node middle = findMiddle(head);
        Node nextMiddle = middle.next;
        middle.next = null;
        Node left = sort(head);
        Node right = sort(nextMiddle);
        Node sortedNodes = merge(left, right);
        return sortedNodes;
    }

    public Node merge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node result = null;
        if (a.data < b.data) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }

    public Node findMiddle(Node head) {
        if (head == null)
            return null;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void mergeTwoSorted(Node head1, Node head2) {

        Node ptr1 = head1;
        Node ptr2 = head2;
        Node list = new Node(-1);
        Node temp = list;
        while (ptr1 != null && ptr2 != null) {

            if (ptr1.data == ptr2.data) {
                temp.next = new Node(ptr1.data);
                temp = temp.next;

                temp.next = new Node(ptr2.data);
                temp = temp.next;

                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            } else if (ptr1.data < ptr2.data) {
                temp.next = new Node(ptr1.data);
                ;
                temp = temp.next;
                ptr1 = ptr1.next;
            } else {
                temp.next = new Node(ptr2.data);
                temp = temp.next;
                ptr2 = ptr2.next;
            }
        }
        while (ptr1 != null) {
            temp.next = new Node(ptr1.data);
            temp = temp.next;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            temp.next = new Node(ptr2.data);
            temp = temp.next;
            ptr2 = ptr2.next;
        }
        temp.next = null;
        root = list.next;
    }

    public void removeDuplicatedFromSortedList() {
        Node temp = root;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                Node next = temp.next.next;
                temp.next = next;
            }
            temp = temp.next;
        }
    }

    public void mergeTwoSortedListFromEnd(Node head1, Node head2) {

        Node ptr1 = head1, prev1 = null;
        while (ptr1 != null) {
            Node next = ptr1.next;
            ptr1.next = prev1;
            prev1 = ptr1;
            ptr1 = next;
        }
        head1 = prev1;


        Node ptr2 = head2, prev2 = null;
        while (ptr2 != null) {
            Node next = ptr2.next;
            ptr2.next = prev2;
            prev2 = ptr2;
            ptr2 = next;
        }
        head2 = prev2;


        ptr1 = head1;
        ptr2 = head2;
        Node list = new Node(-1);
        Node ptr3 = list;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data == prev2.data) {
                ptr3.next = new Node(ptr1.data);
                ptr3 = ptr3.next;

                ptr3.next = new Node(ptr2.data);
                ptr3 = ptr3.next;

                ptr1 = ptr1.next;
                ptr2 = prev2.next;

            } else if (ptr1.data > ptr2.data) {
                ptr3.next = new Node(ptr1.data);
                ptr3 = ptr3.next;
                ptr1 = ptr1.next;
            } else {
                ptr3.next = new Node(ptr2.data);
                ptr3 = ptr3.next;
                ptr2 = ptr2.next;
            }
        }
        while (ptr1 != null) {
            ptr3.next = new Node(ptr1.data);
            ptr3 = ptr3.next;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            ptr3.next = new Node(ptr2.data);
            ptr3 = ptr3.next;
            ptr2 = ptr2.next;
        }
        ptr3.next = null;
        root = list.next;


    }

    public void mergingAlternateNodes(Node head1, Node head2) {
        Node ptr1 = head1;
        Node ptr2 = head2;
        Node list = new Node(-1);
        Node temp = list;
        int i = 0;
        while (ptr1 != null && ptr2 != null) {
            if (i == 0) {
                temp.next = ptr1;
                temp = temp.next;
                ptr1 = ptr1.next;
                i = 1;
            } else {
                temp.next = ptr2;
                temp = temp.next;
                ptr2 = ptr2.next;
                i = 0;
            }
        }
        while (ptr1 != null) {
            temp.next = ptr1;
            temp = temp.next;
            ptr1 = ptr1.next;

        }
        while (ptr2 != null) {
            temp.next = ptr2;
            temp = temp.next;
            ptr2 = ptr2.next;
        }

        root = list.next;
    }

    public void spilitNodes() {
        int k = size % 2 != 0 ? (size / 2) + 1 : size / 2;

        Node first = new Node(-1);
        Node second = new Node(-1);
        Node left = first;
        Node right = second;
        Node temp = root;
        int counter = 1;
        while (temp != null) {
            if (counter <= k) {
                left.next = temp;
                left = left.next;
            } else {
                right.next = temp;
                right = right.next;
            }
            if (temp.next == null) {
                left.next = null;
                right.next = null;
            }
            counter++;
            temp = temp.next;
        }
        root = first.next;
        display();
        root = second.next;
        display();
    }

    public void partition(int k) {
        Node first = new Node(-1);
        Node second = new Node(-1);
        Node left = first;
        Node right = second;
        Node temp = root;
        Node start = second;
        while (temp != null) {
            if (temp.data < k) {
                left.next = temp;
                left = left.next;
            } else {
                right.next = temp;
                right = right.next;
            }
            temp = temp.next;
        }
        right.next = null;
        left.next = second.next;
        root = first.next;

    }

    public void deleteNNodesMSkip(int m, int n) {
        Node current = root, prev = null;
        int mcounter = 0;
        int ncounter = 0;
        while (current != null) {
            if (mcounter >= m && ncounter < n) {
                ncounter++;
            } else if (ncounter == n) {
                mcounter = 0;
                mcounter++;
                prev.next = current;
                prev = prev.next;
                ncounter = 0;
            } else if (mcounter < m) {
                ncounter = 0;
                mcounter++;
                prev = current;
            }
            if (current.next == null) {
                prev.next = null;
                prev = prev.next;
            }
            current = current.next;
        }
    }

    public void reverseKthNode(int k) {
        Node current = root, temp = null, prev = null;
        int counter = k;
        while (current != null && counter > 0) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            counter--;
        }
        temp = prev;
        while (counter <= k && temp.next != null) {
            temp = temp.next;
            counter++;
        }
        while (current != null) {

            temp.next = current;
            current = current.next;
        }
        root = prev;
    }

    public void reverse() {
        Node temp = root, prev = null;
        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        root = prev;
    }

    public void reverseRec(Node p) {
        if (p.next == null) {
            root = p;
            return;
        }
        reverseRec(p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
    }

    public Node reverseKGroup(Node head, int k) {
        Node current = head, prev = null;
        int counter = 0;
        Node next = null;
        while (counter < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            counter++;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }

    public void addFirst(int data) {
        if (root == null) {
            root = new Node(data);
            size++;
        } else {
            Node temp = root;
            Node node = new Node(data);
            node.next = temp;
            root = node;
            size++;
        }
    }

    public void pairReverse() {
        Node p = root;
        Node start = p.next;
        while (true) {
            Node q = p.next;
            Node temp = q.next;
            q.next = p;
            if (temp == null || temp.next == null) {
                p.next = temp;
                break;
            }
            p.next = temp.next;
            p = temp;
        }
        root = start;
    }

    public int mid() {
        Node slow = root, fast = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
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
}
