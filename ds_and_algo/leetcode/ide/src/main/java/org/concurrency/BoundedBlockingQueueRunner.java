package org.concurrency;

public class BoundedBlockingQueueRunner {


    public static void main(String[] args) {
        final BoundedBlockingQueue boundedBlockingQueue = new BoundedBlockingQueue(2);
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boundedBlockingQueue.enqueue(1);
                    System.out.println("size after enqueue(1) :" + boundedBlockingQueue.size());
                    boundedBlockingQueue.enqueue(2);
                    System.out.println("size after enqueue(2) :" + boundedBlockingQueue.size());
                    //boundedBlockingQueue.enqueue(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(boundedBlockingQueue.dequeue());
                    System.out.println("size after dequeue() first :" + boundedBlockingQueue.size());
                    System.out.println(boundedBlockingQueue.dequeue());
                    System.out.println("size after dequeue() second :" + boundedBlockingQueue.size());
                    //System.out.println(boundedBlockingQueue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        a.start();
        b.start();
    }
}
