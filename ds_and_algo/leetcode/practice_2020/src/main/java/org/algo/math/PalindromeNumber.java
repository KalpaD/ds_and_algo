package org.algo.math;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        int signum = Integer.signum(x);
        if (signum == -1) {
            return false;
        }

        String stringX = Integer.toString(x);
        int len = stringX.length();
        for (int i = 0; i < len / 2; i++) {
            if (stringX.charAt(i) != stringX.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Without converting the int to String
     */
    public boolean isPalindromeImproved(int x) {

        // if x < 0 or x is divisible by 10
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverted = 0;
        while (x > reverted) {
            // using the remainder operator to get the last digit
            int lastDigit = x % 10;
            // using the * by 10 to build the reverted number
            reverted = reverted * 10 + lastDigit;
            // using divided by 10 to remove the last digit from x
            x = x / 10;
        }

        return x == reverted || x == reverted / 10;
    }
}
