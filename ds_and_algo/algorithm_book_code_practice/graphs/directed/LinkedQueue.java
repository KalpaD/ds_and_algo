import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a linked list based queue implementation
 * It supports follwing operations
 * enqueu()
 * dequeue()
 * isEmpty()
 * size()
 */
public class LinkedQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int numberOfNodes;
    
    private class Node<Item> {
        private Item item;
        private Node next;

        Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    /**
     * Returns a boolen value indicating empty queue.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the size of the queue.
     */
    public int size() {
        return numberOfNodes;
    }

    /**
     * Enqueu append new item to the end of the queue.
     */
    public void enqueue(Item item) {
        if (item == null) {
            System.out.println("null item detected, hence enqueu will not happen.");
            return;
        }
        Node oldLast = last;
        last = new Node(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        numberOfNodes++;
    }

    /**
     * Dequeu remove item from the fron of the queue.
     */
    public Item dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Item fItem = (Item) first.item;
        first = first.next;
        numberOfNodes--;

        if (isEmpty()) {
            last = null; // avoid loitering
        }
        return fItem;
    }

    public Iterator<Item> iterator() {
        return new LinkedQueueIterator<Item>(first);
    }

    private class LinkedQueueIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        LinkedQueueIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String [] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}