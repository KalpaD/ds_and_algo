package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {

    private MergeSortedArrays mergeSortedArrays;

    @BeforeEach
    void setUp() {
        mergeSortedArrays = new MergeSortedArrays();
    }

    @Test
    void merge() {
        int [] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int m = 6;
        int [] nums2  = {1,2,2};
        int n = 3;

        int [] expected = {-1, 0, 0, 1, 2, 2, 3, 3, 3};
        assertArrayEquals(expected, mergeSortedArrays.merge(nums1, m, nums2, n));
    }
}