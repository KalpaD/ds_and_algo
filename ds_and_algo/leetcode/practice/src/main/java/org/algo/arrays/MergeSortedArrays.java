package org.algo.arrays;


public class MergeSortedArrays {

    public int [] merge(int[] nums1, int m, int[] nums2, int n) {

        int n1i = m - 1;
        int n2j = n - 1;
        int filIndex = nums1.length - 1;
        while (n1i >= 0 || n2j >= 0 && filIndex >= 0) {

            int currenti = Integer.MIN_VALUE;
            if (n1i >= 0) {
                currenti = nums1[n1i];
            }

            int currentj = Integer.MIN_VALUE;
            if (n2j >= 0) {
                currentj = nums2[n2j];
            }

            if (currenti >= currentj) {
                nums1[filIndex--] = nums1[n1i];
                n1i--;
            } else {
                nums1[filIndex--] = nums2[n2j];
                n2j--;
            }
        }

        return nums1;
    }
}
