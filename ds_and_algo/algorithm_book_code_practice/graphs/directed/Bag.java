import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{

    private Node<Item> head;
    private int n;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;

        Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    public void add(Item item) {
       Node<Item> oldhead = head;
       head = new Node<Item>(item);
       head.next = oldhead;
       n++;
       return;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new BagIterator<Item>(head);
    }

    private class BagIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        BagIterator(Node<Item> head) {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }
        
        public Item next() {
            if (!hasNext()) {
                return null;
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String [] args) {
        Bag<String> bag = new Bag<String>();
        bag.add("A");
        bag.add("B");

        for (String s : bag) {
            System.out.println(s);
        }
    }

}