package org.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class FizzBuzzRunner {

    Runnable printFizz = () -> System.out.println("fizz");

    Runnable printBuzz = () -> System.out.println("buzz");

    Runnable printFizzbuzz = () -> System.out.println("fizzbuzz");

    IntConsumer printNumber = (num) -> System.out.println(num);


    ExecutorService executor = Executors.newFixedThreadPool(4);

    private void run() {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
    }

    public static void main(String[] args) {

        FizzBuzzRunner fizzBuzzRunner = new FizzBuzzRunner();
        fizzBuzzRunner.run();

    }
}
