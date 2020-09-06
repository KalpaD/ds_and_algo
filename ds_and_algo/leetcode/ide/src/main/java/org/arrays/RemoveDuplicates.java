package org.arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

       for (int index = 0; index < nums.length; index++) {
           int lookup = index;
           while (lookup+ 1 < nums.length && nums[index] == nums[lookup + 1]) {
               ++lookup;
           }
           // found the next unique element
           swap(nums, (index + 1), lookup);
       }

       for (int i = 0; i < nums.length; i++) {
           System.out.print(nums[i]);
       }
       return 0;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }
}
