package org.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindPivotIndex {

    /**
     * Given an array of integers nums, write a method that returns the "pivot" index of this array.
     * We define the pivot index as the index where
     * the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
     * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {

        Map<Integer, Integer> indexToSum = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int value = nums[index];
            // for the first index we just need the value
            if (index == 0) {
                indexToSum.put(index, value);
            }
            else {
                // for the rest of the indexes
                int previousSum = indexToSum.get((index - 1));
                int currentSum = previousSum + nums[index];
                indexToSum.put(index, currentSum);
            }
        }

        // pre calculation done
        for (int index = 0; index < nums.length; index++) {
            int sumOfLeftToIndex = indexToSum.get(index) - nums[index];
            int sumOfRightToIndex = indexToSum.get(nums.length - 1) - (indexToSum.get(index));
            if (sumOfLeftToIndex == sumOfRightToIndex) {
                return index;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
       int [] nums = {1,7,3,6,5,6};
       int [] nums1 = {1,2,3};
       int [] nums2 = {-1, -1, -1, 0, 1, 1};
       int pivotIndex = pivotIndex(nums2);
       System.out.println("pivotIndex : " + pivotIndex);
    }
}
