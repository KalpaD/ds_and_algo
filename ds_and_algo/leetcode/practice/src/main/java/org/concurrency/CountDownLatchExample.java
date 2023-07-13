package org.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    // CountDownLatch class allows one or more threads to wait until a set of operations
    // being performed in other threads completes.
    // It is initialized with a count,
    // and the await() method blocks the calling thread until the count reaches zero.

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3 ; i++) {
            Thread t = new Thread(new Worker("thread_" + i, latch));
            t.start();
        }

        // keep the main thread running until all workers finish their work
        latch.await();
    }

    private static class Worker implements Runnable {
        private final String name;
        private final CountDownLatch latch;

        public Worker(String name, CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Execution started for thread " + name);
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                System.out.println("Thread " + name + " interrupted" + e);
            }
            System.out.println("Execution finished for thread " + name);

            latch.countDown();
        }
    }
}
