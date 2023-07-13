package org.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CASContentionExample {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger();
        CountDownLatch latch = new CountDownLatch(20);

        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new CounterUpdater("t_" + i, counter, latch));
            t.start();
        }

        // make main thread wait until all others finished
        latch.await();

        System.out.println("Final counter value : " + counter.get());
    }


    private static class CounterUpdater implements Runnable {
        private final String name;
        private final AtomicInteger counter;
        private final CountDownLatch latch;

        public CounterUpdater(String name, AtomicInteger counter, CountDownLatch latch) {
            this.name = name;
            this.counter = counter;
            this.latch = latch;
        }

        @Override
        public void run() {
            int expectedValue = counter.get();
            int newValue = expectedValue + 1;

            boolean updated = false;
            while (!updated) {

                if (counter.compareAndSet(expectedValue, newValue)) {
                    // this thread was able to update the value
                    System.out.println("Updating counter by " + name);
                    updated = true;
                    latch.countDown();
                } else {
                    System.out.println("Updating attempt failed by " + name);
                }
            }
        }
    }
}
