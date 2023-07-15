package org.algo.recursion;

public class Fib {
    private static int [] mem = null;
    public static int getNthFib(int n) {
        if (mem == null) {
            mem = new int [n - 1];
        }

        // Write your code here.
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        int n_1 = 0;
        int n_2 = 0;
        if (mem[n - 1] != 0) {
            n_1 = mem[n - 1];
        }
        else {
            mem[n - 1] = getNthFib(n - 1);
            n_1 = mem[n - 1];
        }

        if (mem[n -2] != 0) {
            n_2 = mem[n - 2];
        }
        else {
            mem[n - 2] = getNthFib(n - 2);
            n_2 = mem[n - 2];
        }

        return n_1 + n_2;
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(8));
    }
}
