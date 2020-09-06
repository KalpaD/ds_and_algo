package org.other;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {

        return IntStream.range(1, n + 1)
                .mapToObj(num -> {
                    boolean isDividedBy3 = false;
                    boolean isDividedBy5 = false;

                    if (num % 3 == 0) {
                        isDividedBy3 = true;
                    }

                    if (num % 5 == 0) {
                        isDividedBy5 = true;
                    }

                    if (isDividedBy3 && isDividedBy5) {
                        return "FizzBuzz";
                    } else if (isDividedBy3) {
                        return "Fizz";
                    } else if (isDividedBy5){
                        return "Buzz";
                    } else {
                        return Integer.toString(num);
                    }
                }).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        fizzBuzz(15).stream().forEach(item -> System.out.println(item));
    }
}
