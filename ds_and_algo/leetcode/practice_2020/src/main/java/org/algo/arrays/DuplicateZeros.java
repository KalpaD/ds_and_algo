package org.algo.arrays;

import java.util.Arrays;

public class DuplicateZeros {

    public int[] duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1 && arr[i] == 0) {
                moveRightByOne(arr, i + 1);
                i++;
            }
        }
        return arr;
    }

    private int[] moveRightByOne(int[] arr, int startIndex) {
        for (int i = arr.length - 1; i >= startIndex; i--) {
            arr[i] = arr[i - 1];
        }
        return arr;
    }

    public int[] duplicateZerosWithAdditionalMemory(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0, j = 0; i < arr.length & j + 2 < arr.length; i++) {
            if (i != arr.length - 1 && arr[i] == 0) {
                newArr[j++] = 0;
                newArr[j++] = 0;
            } else {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    // solution from leetcode
    public int [] duplicateZerosSol(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }

        return arr;
    }
}
