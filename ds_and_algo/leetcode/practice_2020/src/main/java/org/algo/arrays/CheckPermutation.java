package org.algo.arrays;

public class CheckPermutation {

    public boolean isPermutation(String s, String p) {

        if (s.length() != p.length()) {
            return false;
        }

        // assume tha the string only contains the ASCII chars
        boolean [] found = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            found[index] = true;
        }

        for (int j = 0; j < p.length(); j++) {
            int index = p.charAt(j);
            if (!found[index]) {
                return false;
            }
        }
        return true;
    }

}
