import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else  {
            oldlast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Item oldeFirstItem = (Item)first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;  // to avoid loitering
        }
        return oldeFirstItem;
    }

    public boolean isEmpty() {
        return first == null;
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
            // move the pointer to next item
            current = current.next;
            return currentItem;
        }

        public void remove() {
            throw new NotImplementedException();
        }
    }

    public static void main(String [] args) {

        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        queue.dequeue();
    }

}
