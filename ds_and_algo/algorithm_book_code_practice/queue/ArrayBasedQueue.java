import java.util.NoSuchElementException;

public class ArrayBasedQueue<Item> {
    private static final int INIT_SIZE = 5;

    private Item [] items;
    private int numberOfItems;
    private int front;
    private int rear;
    private int capacity;

    ArrayBasedQueue() {
        items = (Item []) new Object[INIT_SIZE];
        front = 0;
        rear = -1;
        capacity = INIT_SIZE;
        numberOfItems = 0;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public int size() {
        return numberOfItems;
    }

    public void enqueue(Item item) {
        if (numberOfItems == capacity) {
            resize(2 * capacity);
        }
        items[++rear] = item;
        numberOfItems++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item itemToReturn = items[front]; // get the first item
        items[front] = null;               // avoid loitering
        numberOfItems--;
        front++;                          // increment first
        if (front == items.length) {
            front = 0;
        }
        if (numberOfItems > 0 && numberOfItems == capacity / 4) {
            resize(capacity / 2);
        }
        return itemToReturn;
    }

    private void resize(int size) {
        Item [] temp = (Item []) new Object[size];
        // copy the current values to the new one
        for (int i = 0; i < numberOfItems; i++) {
            int effectiveIndex = (front + i) % capacity;
            temp[i] = items[effectiveIndex];
        }
        capacity = temp.length;
        items = temp;
        front = 0; // set the front to 0 in the new array
        rear = numberOfItems; // we took numberOfItems items starting from front
    }

    /**
     * Helper method to get the cpacity
     */
    public int getCapacity() {
        return capacity;
    }


    public static void main(String [] args) {
        ArrayBasedQueue<String> queue = new ArrayBasedQueue<String>();
        System.out.println("Capacity begining: "+queue.getCapacity());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Capacity after 3 items: "+queue.getCapacity());
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        System.out.println("Capacity after 6 items: "+queue.getCapacity());
        queue.enqueue("G");
        queue.enqueue("H");
        queue.enqueue("I");
        System.out.println("Capacity after 9 items: "+queue.getCapacity());
    
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("Capacity after 3 dequeues: "+queue.getCapacity());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("Capacity after 5 dequeues: "+queue.getCapacity());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("Capacity after 8 dequeues: "+queue.getCapacity());
    }

}