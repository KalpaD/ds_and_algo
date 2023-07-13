package org.concurrency;

import java.time.Instant;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Question: Implement a multi-threaded program that simulates a queue of customers waiting to enter a store.
 * The program should use the ConcurrentLinkedQueue data structure to manage the customer queue. The program should have the following features:
 *
 * The program should create a queue to store the customers waiting to enter the store.
 * Implement a Customer class that represents a customer. Each customer should have a unique ID.
 * Create a Producer class that generates customers and adds them to the queue.
 *  The producer should generate a new customer every 1 second. The program should run for a total of 10 seconds.
 * Create a Consumer class that dequeues customers from the queue and processes them.
 *  The consumer should process each customer by displaying their ID and the current timestamp. The consumer should continuously process customers until the queue becomes empty.
 * The producer and consumer should run in separate threads.
 * Ensure thread safety by properly synchronizing access to the queue using data structure.
 * Your task is to implement the Customer, Producer, and Consumer classes, and the main program logic.
 */
public class ConcurrentLinkedQueueExample {

    private static class Customer {
        private final UUID id;

        public Customer(UUID id) {
            this.id = id;
        }

        public String getId() {
            return id.toString();
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .toString();
        }
    }

    private static class Producer implements Runnable {
        private final ConcurrentLinkedQueue<Customer> customerQueue;

        public Producer(ConcurrentLinkedQueue<Customer> customerQueue) {
            this.customerQueue = customerQueue;
        }

        @Override
        public void run() {
            Customer customer = new Customer(UUID.randomUUID());
            System.out.println("Created customer " + customer);
            customerQueue.add(customer);
        }
    }

    private static class Consumer implements Runnable {
        private final ConcurrentLinkedQueue<Customer> customerQueue;

        public Consumer(ConcurrentLinkedQueue<Customer> customerQueue) {
            this.customerQueue = customerQueue;
        }

        @Override
        public void run() {
            if (!customerQueue.isEmpty()) {
                System.out.println("Serving customer " + customerQueue.poll() + " at " + Instant.now());
            }
            else {
                System.out.println("No customers in the queue");
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Customer> queue = new ConcurrentLinkedQueue<>();

        ScheduledExecutorService producerExecutor = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService consumerExecutor = Executors.newScheduledThreadPool(1);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producerExecutor.scheduleAtFixedRate(producer, 2, 20, TimeUnit.SECONDS);
        consumerExecutor.scheduleAtFixedRate(consumer, 5, 20, TimeUnit.SECONDS);
    }
}

