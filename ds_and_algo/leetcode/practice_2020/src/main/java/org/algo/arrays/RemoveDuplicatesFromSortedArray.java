package org.algo.arrays;

public class RemoveDuplicatesFromSortedArray {

        public int removeDuplicates(int[] nums) {

            if (nums.length == 0) {
                return 0;
            }

            int dest = 0;
            int current = nums[0];

            for (int source = 0; source < nums.length; source++) {

                if (current != nums[source]) {
                    nums[++dest] = nums[source];
                    current = nums[source];
                }
            }

            return dest + 1;
        }
}
