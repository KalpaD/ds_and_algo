package org.algo.arrays;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int conOne = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                counter++;
            }

            if (i + 1 >= nums.length || counter > 0 && nums[i] != 1) {
                conOne = Math.max(conOne, counter);
                counter = 0;
            }
        }

        return conOne;

    }
}
