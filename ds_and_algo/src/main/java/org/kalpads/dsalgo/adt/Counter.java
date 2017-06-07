package org.kalpads.dsalgo.adt;

/**
 * Created by kalpasenanayake on 6/6/17.
 */
public class Counter {

    private String name = null;
    private int counter  = 0;

    public Counter(String str) {
        this.name = str;
    }

    public void increment() {
        counter ++;
    }

    public int getCurrentValue() {
        return this.counter;
    }

    public String toString() {
        return name + " " + counter;
    }
}
