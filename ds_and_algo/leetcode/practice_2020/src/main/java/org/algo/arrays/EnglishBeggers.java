package org.algo.arrays;


public class EnglishBeggers {

    public int[] beggars(int[] values, int n) {
        if (n <= 0) {
            return new int[] {};
        }
        int [] res = new int [n];
        int nIndex = 0;
        for (int i = 0; i < values.length; i++, nIndex++) {
            if (nIndex >= n) {
                nIndex = 0;
            }
            res[nIndex] = res[nIndex] + values[i];
        }

        return res;
    }
}
