package org.algo.math;


public class ReverseInteger {

    /**
     * Here to keep the time complexity O(n/2) and space complexity O(n)
     * we can use the same array to swap chars. And make sure to use the n - 1 - i
     * to access the array from the rear end.
     */
    public int reverse(int x) {

        int sigNum = Integer.signum(x);
        char[] chars = Integer.toString(Math.abs(x)).toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
        try {
            return Integer.parseInt(new String(chars)) * sigNum;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
