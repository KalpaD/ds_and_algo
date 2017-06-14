package org.kalpads.dsalgo.queue;

/**
 * Created by kalpasenanayake on 7/6/17.
 */
public class Queue<T> {

    private int maxSize;        // maximum size of the queue.
    private T [] queueArray;
    private int front;          // keep track of the front element in the queue.
    private int rear;           // keep track of the rear element of the queue.
    private int numberOfItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray      = (T[]) new Object[maxSize]; // init the array with max size.
        front           = 0;
        rear            = -1; // rear is set to -1 since we want 1st insert to be in 0th position.
        numberOfItems   = 0;
    }

    public void insert(T item) {
        rear++;                 // increment the rear
        queueArray[rear] = item;
        numberOfItems++;
    }

    public T remove() {
        T frontItem = queueArray[front]; // get the front element
        front++; // increment front do it will point to next element
        if(front == maxSize) {
            front = 0; // queue is full
        }
        numberOfItems--;
        return frontItem;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public boolean isFull() {
        return numberOfItems == maxSize;
    }

    public void view() {
        System.out.print("[");
        for (int i = front; i <= rear; i++) {
            System.out.print(queueArray[i] +" ");
        }
        System.out.print("]");
    }
}
