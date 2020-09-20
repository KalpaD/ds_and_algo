package org.algo.arrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutations {

    // T =O(2n) =~ O(n)
    public boolean isPalindromePermutation(String s) {

        String cleanSting = s.toLowerCase().replaceAll("\\s+", "");
        Map<Character, Integer> characterIntegerMap = buildCharMap(cleanSting);
        return permutationCheck(characterIntegerMap);

    }
    // T  = O(n)
    private Map<Character, Integer> buildCharMap(String s) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (charMap.get(c) == null) {
                charMap.put(c, 1);
            }
            else {
                int f = charMap.get(c);
                charMap.put(c, ++f);
            }
        }

        return charMap;
    }

    // T = O(n)
    private boolean permutationCheck(Map<Character, Integer> charMap) {

        boolean f1CharFound = false;

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {

            int f = entry.getValue();

            if (f == 1 && !f1CharFound) {
                f1CharFound = true;
            }
            else if (f > 1 && f % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    // this use the int [] based hash table approach
    public boolean isPalindromePermutation2(String s) {
        int[] table = buildFrequencyTable(s);
        return checkMaxOneOdd(table);
    }

    boolean checkMaxOneOdd(int [] table) {
        boolean foundOneOdd = false;
        for (int x : table) {
            if (x % 2 == 1) {
                if (foundOneOdd) {
                    return false;
                }
                foundOneOdd = true;
            }
        }
        return true;
    }

    int [] buildFrequencyTable(String s) {
        int tableSize = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;
        int [] table = new int[tableSize];

        for (char c : s.toCharArray()) {
            int x = getCharNumberInTable(c);
            if (x != -1) {
                table[x] = table[x] + 1;
            }
        }
        return table;
    }

    //  0  1  2  3        25
    // [a, b, c, d ...... z]
    // [1, 1, 2, 5 ...... 3]
    int getCharNumberInTable(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        // -1 if the character has no numeric value.
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

}
