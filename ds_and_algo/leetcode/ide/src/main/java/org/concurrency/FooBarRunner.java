package org.concurrency;

public class FooBarRunner {

    FooBar fooBar = new FooBar(2);
    Runnable printFoo = new Runnable() {
        @Override
        public void run() {
            System.out.println("foo");
        }
    };

    Runnable printBar = new Runnable() {
        @Override
        public void run() {
            System.out.println("bar");
        }
    };

    public void run() {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(printFoo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(printBar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.start();
        b.start();

    }


    public static void main(String[] args) throws InterruptedException {
        FooBarRunner fooBarRunner = new FooBarRunner();
        fooBarRunner.run();
        Thread.sleep(10000);

    }
}
