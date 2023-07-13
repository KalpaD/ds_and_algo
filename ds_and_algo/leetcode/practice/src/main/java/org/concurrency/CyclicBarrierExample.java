package org.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    //The CyclicBarrier class allows a set of threads to wait at a synchronization point
    // until all threads have reached that point. Once all threads have arrived,
    // a barrier action is executed.
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i ++) {
            Thread t = new Thread(new Worker("worker_"+ i, barrier));
            t.start();
        }
    }

    private static class Worker implements Runnable {
        private final String name;
        private final CyclicBarrier barrier;

        public Worker(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker is performing a task. " + name);

                Thread.sleep(3000);
                // make each thread wait until all of them are at this point
                barrier.await();
                System.out.println("Worker has passed the barrier.");
            }
            catch (InterruptedException | BrokenBarrierException e) {
                System.out.println("Thread " + name + " interrupted" + e);
            }
        }
    }
}
