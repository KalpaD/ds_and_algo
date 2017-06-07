package org.kalpads.dsalgo;


import org.kalpads.dsalgo.adt.Counter;

public class App {

    public static void main( String[] args ) {
        Counter counter = new Counter("myCounter");
        counter.increment();

        System.out.println(counter.toString());
    }
}
