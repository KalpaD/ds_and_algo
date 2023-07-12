package org.algo.arrays;

public class FindNumbersEvenNumberDigits {


    public int findNumbers(int[] nums) {

        int evenCount = 0;

        for (int i = 0; i < nums.length; i++) {
             int current = nums[i];
             int count = 0;
             while (current != 0) {
                 current = current / 10;
                 count++;
             }
             if (count % 2 == 0) {
                 evenCount++;
             }
        }

        return evenCount;
    }
}
