package org.algo.arrays;

import java.util.HashSet;

public class RemoveSpecifiedChars {

    public String removeChars(String str, String remove) {
        //T = O(m) S = O(m), m = number chars in remove
        HashSet<Character> removeSet = buildHashTable(remove);

        //T =- O(n), n = number of chars in the str; S = O(p), p = final number of chars in the resulted string
        char [] strArray = str.toCharArray();
        int src = 0;
        int dst = 0;
        while (src < str.length()) {
            if (!removeSet.contains(strArray[src])) {
                strArray[dst++] = strArray[src];
            }
            src++;
        }

        return new String(strArray, 0, dst);
    }

    private HashSet<Character> buildHashTable(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
