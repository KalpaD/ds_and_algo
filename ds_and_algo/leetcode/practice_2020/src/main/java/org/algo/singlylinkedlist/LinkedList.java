package org.algo.singlylinkedlist;

public class LinkedList {

    public Node head;

    class Node {
        public Node next;
        public int val;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // push at head T = O(1) , S = O(1)
    public Node push(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        return newHead;
    }

    // append T = O(n), S = O(1), where n = number of nodes in the list.
    public void append(int val) {
        Node newNode = new Node(val);

        // no nodes case
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // found the last node
        // set the new node
        current.next = newNode;
    }

    // insert after given node
    // T = O(1), S = O(1)
    public void insert(Node prevNode, int val) {
        Node newNode = new Node(val);

        newNode.next = prevNode.next;

        prevNode.next = newNode;
    }

    // T = O(n), S = O(1)
    public void deleteNodeByKey(int val) {
        Node current = head;

        if (current != null && current.val == val) {
            head = current.next;
            return;
        }

        while (current != null && current.next.val != val) {
            current = current.next;
        }

        current.next = current.next.next;
    }

}
