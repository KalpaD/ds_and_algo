
public class LinkedList {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    } 

    //1) At the front of the linked list
    public Node push(int data) {
        // create a new node
        Node newNode = new Node(data);
        // set the next of new node as head
        newNode.next = head;
        // move the head to newnode
        head = newNode;

        return head;
    }

    //2) After a given node.
    public void insert(Node prevNode, int data) {
         if (prevNode == null) {
             System.out.println("previous node can not be null");
             return;
         }
         // create a new node
         Node newNode = new Node(data);
         // set the prev node next as the new node's next
         newNode.next = prevNode.next;
         // set the next node as the next of the previous node.
         prevNode.next = newNode;
    }

    //3) At the end of the linked list.
    public void append(int data) {
        Node newnode = new Node(data);

        if (head == null) {
            // then the list id empty , hence nex node should be the first node
            head = newnode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // when exit the loop, we have the last node as current
        current.next = newnode;
    }

    public void deleteNodebyKey(int key) {
        Node current = head;

        // if the head contains the key
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        while (current.next.data != key) {
            current = current.next;
        }
        // if key was not present in the list
        if (current == null) {
            return;
        }
        // we found the previous node
        current.next = current.next.next;
    }


    public static void main(String [] args) {
        LinkedList linkedList  = new LinkedList();

        linkedList.push(3);
        Node prevNode = linkedList.push(1);

        linkedList.insert(prevNode, 2);

        linkedList.append(0);
        
        linkedList.printList();

        linkedList.deleteNodebyKey(3);

        linkedList.printList();
    }

    public void printList() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}