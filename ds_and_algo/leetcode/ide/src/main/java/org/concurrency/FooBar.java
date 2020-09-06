package org.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

    private Lock lock;
    private Condition condition;
    private int n;
    private AtomicBoolean printFooFlag;

    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.printFooFlag = new AtomicBoolean(true);
        this.condition = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (!printFooFlag.get()) {
               condition.await();
            }
            try {
                System.out.println("Thread name in foo " + Thread.currentThread().getName());
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
            } finally {
                printFooFlag.set(false);
                condition.signal();
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (printFooFlag.get()) {
                condition.await();
            }
            try {
                System.out.println("Thread name in bar " + Thread.currentThread().getName());
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
            } finally {
                printFooFlag.set(true);
                condition.signal();
                lock.unlock();
            }
        }
    }
}
