package org.algo.arrays;
import java.util.NoSuchElementException;

public class FirstNonRepeatedChar {

    public char findFirstNonRepeated(String s) {

        //T = O(n),S = O(1)
        int [] table = buildFreqTable(s);
        //T = O(n)
        for (char c : s.toCharArray()) {
            int key = keyInTable(c);
            if (table[key] == 1) {
                return c;
            }
        }

        // T_total = O(n), S = O(1)

        throw new NoSuchElementException();
    }

    private int [] buildFreqTable(String s) {
        int [] table = new int [26];
        for (char c : s.toCharArray()) {
            int key = keyInTable(c);
            if (key != -1) {
                table[key]++;
            }
        }

        return table;
    }

    private int keyInTable(char ch) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int c = Character.getNumericValue(ch);

        if (a <= c && c <= z) {
            return c - a;
        }
        else {
            return -1;
        }
    }
}
