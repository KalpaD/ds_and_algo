package org.kds;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        // create the single final array
        int [] mArray = new int [n+m];

        while (i < n && j < m) {

            int num1sVal = 0;
            while (i < n) {
                num1sVal = nums1[i];
                break;
            }

            int nums2Val = 0;
            while (j < m) {
                nums2Val = nums2[j];
                break;
            }

            if (num1sVal < nums2Val) {
                i++;
                mArray[k++] = num1sVal;
            } else {
                j++;
                mArray[k++] = nums2Val;
            }
        }

        // if nums1 has leftovers
        while ( i < n ) {
            mArray[k++] =  nums1[i++];
        }

        while (j < m) {
            mArray[k++] =  nums2[j++];
        }

        double median  = 0;

        int len  = n + m;
        if (len % 2 == 0) {
            int locatioin = len / 2;
            median = (double) ( mArray[locatioin -1] + mArray[locatioin] ) / 2;

        } else {
            median = (double) mArray[len/2];
        }
        return median;
    }

    public static void main(String [] args) {
        //int [] nums1 = {1, 2};
        //int [] nums2 = {3, 4};

        int [] nums1 = {2, 3, 5};
        int [] nums2 = {7, 8, 9, 10};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double median  = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
