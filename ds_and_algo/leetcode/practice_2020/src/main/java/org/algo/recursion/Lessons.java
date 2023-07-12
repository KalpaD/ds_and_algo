package org.algo.recursion;

public class Lessons {

    public static int triangle(int n) {

        int total = 0;
        while (n > 0) {
            total = total + n;
            n--;
        }

        return total;
    }

    public static int triangleRecursion(int n) {

        // base case
        if (n == 1) {
            return 1;
        }
        else {
            return (n + triangle(n - 1));
        }
    }


    public static void main(String[] args) {
        System.out.println("triangle(5) : " + triangle(5));
        System.out.println("triangleRecursion(5) : " + triangleRecursion(5));
    }
}
