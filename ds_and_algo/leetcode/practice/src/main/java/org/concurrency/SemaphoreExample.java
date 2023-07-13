package org.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    // The Semaphore class is used to control access to a limited number of resources.
    // It maintains a set of permits and provides methods to acquire and release these permits.

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0 ; i <= 5 ; i ++) {
            Thread worker = new Thread(new Worker("worker_"+ i, semaphore));
            worker.start();
        }
    }

    private static class Worker implements Runnable {
        private final String name;
        private final Semaphore semaphore;

        public Worker(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                // acquire the permit
                semaphore.acquire();
                System.out.println("Currently used by " + name);

                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                System.out.println("Thread " + name + " interrupted" + e);
            }
            System.out.println("Execution finished by " + name);
            // release the permit
            semaphore.release();
        }
    }
}
