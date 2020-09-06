package org.arrays;

public class LargestNumberAtLeastTwiceOfOthers {

    /**
     * In a given integer array nums, there is always exactly one largest element.
     *
     * Find whether the largest element in the array is at least twice as much as every other number in the array.
     *
     * If it is, return the index of the largest element, otherwise return -1.
     */
    public static int dominantIndex(int[] nums) {

        int indexOfLargestNum = 0;
        int largest = 0;
        for (int index = 0; index < nums.length; index++) {
            if (largest < nums[index]) {
                largest = nums[index];
                indexOfLargestNum = index;
            }
        }

        for (int index = 0; index < nums.length; index++) {

            if (index != indexOfLargestNum) {
                boolean largestGtTwiceOf =  (nums[index] * 2) <= nums[indexOfLargestNum];
                if (!largestGtTwiceOf) {
                    return -1;
                }
            }
        }

        return indexOfLargestNum;
    }

    public static void main(String[] args) {
        int [] nums = {3, 6, 1, 0};
        int dominantIndex = dominantIndex(nums);
        System.out.println("dominantIndex : " + dominantIndex);
    }
}
