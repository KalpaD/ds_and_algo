import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Linked stack is based on singly linked list , and it provides following API for it's clients.
 * push()
 * pop()
 * peek()
 * size()
 * isEmpty()
 */
public class LinkedStack<Item> implements Iterable<Item> {

    private Node<Item> head;    // head node of the stack
    private int n;                  // number of nodes in the stack


    /**
     * Node class represents nodes in the linked list.
     */    
    private class Node<Item> {
        private Item item;
        private Node<Item> next;

        Node(Item item) {
            this.item = item;
        }

        Node(Item item, Node<Item> next) {
            this.item = item;   
            this.next = next;
        }
    }

    /**
     * This operation create new node and attach it as the first node of the stack.
     */
    public void push(Item item) {
        Node<Item> oldHead = head;
        head = new Node<Item>(item);
        head.next = oldHead;
        n++;
    }

    /**
     * This operation remove and return the head of the stack
     */
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty.");
        }
        Item item = head.item;
        head = head.next;
        n--;
        return item;
    }

    /**
     * Return the item at the head without removing it from the stack.
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty.");
        }
        return head.item;
    }

    /**
     * Return the size of the stack
     */
    public int size() {
        return n;
    }

    /**
     * Indicate whather the stack is empty of not via a boolean
     */
     public boolean isEmpty() {
         return head == null;
     }


     public Iterator<Item> iterator() {
        return new LinkedStackIterator<Item>(head);
    }

    private class LinkedStackIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        LinkedStackIterator(Node<Item> head) {
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
         LinkedStack<String> lStack = new LinkedStack<String>();

         System.out.println("isEmpty() : "+ lStack.isEmpty());
         lStack.push("A");
         lStack.push("B");
         lStack.push("C");
         lStack.push("D");
         lStack.push("E");
         lStack.push("F");

         System.out.println("peek() : "+ lStack.peek());
         System.out.println("size() : "+ lStack.size());
         System.out.println("isEmpty() : "+ lStack.isEmpty());

         System.out.println("pop() : "+ lStack.pop());
         System.out.println("pop() : "+ lStack.pop());
         System.out.println("pop() : "+ lStack.pop());
         System.out.println("pop() : "+ lStack.pop());
         System.out.println("pop() : "+ lStack.pop());
         System.out.println("size() : "+ lStack.size());
     }

}