package org.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private Integer [] queue;
    private Lock lock;
    private Condition full;
    private Condition empty;
    private int counter;
    private int front;
    private int rear;

    //[rear , 1, 2, 3 ,..... front]

    public BoundedBlockingQueue(int capacity) {
        queue = new Integer[capacity];
        this.lock = new ReentrantLock();
        this.full = lock.newCondition();
        this.empty = lock.newCondition();
        this.counter = 0;
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            if (counter == queue.length) {
                full.await();
            }
            queue[front] = element;
            if (++front == queue.length) {
                front = 0; // get the queue pointer to font of the queue.
            }
            ++counter;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            if (counter == 0) {
                //queue is empty
                empty.await();
            }
            Integer integer = queue[rear];
            queue[rear] = null;
            if (++rear == queue.length) {
                rear = 0;
            }
            --counter;
            full.signal();
            return integer;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
