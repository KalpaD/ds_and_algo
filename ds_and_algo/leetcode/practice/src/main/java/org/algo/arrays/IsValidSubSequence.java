package org.algo.arrays;

import java.util.List;

public class IsValidSubSequence {

    public boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.

        int j = 0;
        for (int i = 0; i < array.size() && j < sequence.size(); i++) {
            if (array.get(i).equals(sequence.get(j))) {
                j++;
            }
        }
        if (j == sequence.size()) {
            return true;
        }
        else {
            return false;
        }
    }
}
