package org.concurrency;

import java.util.concurrent.Phaser;

public class RaceSimulation {

    private static final int NUM_RUNNERS = 4;
    private static final int NUM_CHECKPOINTS = 3;

    public static void main(String[] args) {
        Phaser phaser = new Phaser(NUM_RUNNERS);

        for (int i = 0; i < NUM_RUNNERS; i++) {

            Thread runner = new Thread(() -> {
                for (int j = 0; j < NUM_CHECKPOINTS; j++) {

                    System.out.println("Runner " + Thread.currentThread().getName() + " reached Checkpoint " + j);

                    phaser.arriveAndAwaitAdvance(); // Synchronize at checkpoint

                    try {
                        Thread.sleep(1000); // Simulate some work at the checkpoint
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Runner " + Thread.currentThread().getName() + " crossed the finish line!");

                phaser.arriveAndDeregister(); // Deregister from the Phaser
            });
            runner.setName(String.valueOf(i));
            runner.start();
        }
    }
}
