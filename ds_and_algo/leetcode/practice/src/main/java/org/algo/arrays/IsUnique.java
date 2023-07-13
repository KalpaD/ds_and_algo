package org.algo.arrays;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public boolean isUnique(String s) {
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        if (s.length() == set.size()) {
            return true;
        }
        else {
            return false;
        }
    }
}
