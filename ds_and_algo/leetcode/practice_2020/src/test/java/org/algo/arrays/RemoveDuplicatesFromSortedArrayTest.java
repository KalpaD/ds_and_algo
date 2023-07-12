package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray;

    @BeforeEach
    void setUp() {
        removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
    }

    @Test
    void removeDuplicates() {
        int [] input = {1, 1, 2};
        assertEquals(2, removeDuplicatesFromSortedArray.removeDuplicates(input));

    }

    @Test
    void removeDuplicates2() {
        int [] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertEquals(5, removeDuplicatesFromSortedArray.removeDuplicates(input));

    }

    @Test
    void removeDuplicates3() {
        int [] input = {};
        assertEquals(0, removeDuplicatesFromSortedArray.removeDuplicates(input));

    }
}