package org.concurrency;

import java.util.concurrent.Semaphore;

public class PrintEvenOddUsingTwoThreads {

    public static void printOddEven(int n) throws InterruptedException {
        Semaphore oddSem = new Semaphore(1);
        Semaphore evenSem = new Semaphore(0);
        Thread ot = new Thread(new OddThread(oddSem, evenSem, n));
        ot.setName("odd thread");
        Thread et = new Thread(new EvenThread(oddSem, evenSem, n));
        et.setName("event thread");

        ot.start();
        et.start();
        ot.join();
        et.join();
    }

    public static void main(String[] args) throws InterruptedException {
        printOddEven(10);
    }


    private static class OddThread implements Runnable {
        Semaphore oddSem;
        Semaphore evenSem;
        private final int n;

        public OddThread(Semaphore oddSem, Semaphore evenSem, int n) {
            this.oddSem = oddSem;
            this.evenSem = evenSem;
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 1; i <= n; i = i + 2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "trying to get oddSem");
                    oddSem.acquire();
                    System.out.println(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    evenSem.release();
                }
            }
        }
    }

    private static class EvenThread implements Runnable {
        Semaphore oddSem;
        Semaphore evenSem;
        private final int n;

        public EvenThread(Semaphore oddSem, Semaphore evenSem, int n) {
            this.oddSem = oddSem;
            this.evenSem = evenSem;
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 2; i <= n; i = i + 2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "trying to get evenSem");
                    evenSem.acquire();
                    System.out.println(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    oddSem.release();
                }
            }
        }
    }
}
