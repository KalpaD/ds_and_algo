package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateZerosTest {

    private DuplicateZeros duplicateZeros;

    @BeforeEach
    void setUp() {
        duplicateZeros = new DuplicateZeros();
    }

    @Test
    void duplicateZeros() {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] arr1Expected = {1, 0, 0, 2, 3, 0, 0, 4};
        int[] arr2 = {8, 4, 5, 0, 0, 0, 0, 7};
        int[] arr2Expected = {8, 4, 5, 0, 0, 0, 0, 0};
        assertArrayEquals(arr1Expected, duplicateZeros.duplicateZeros(arr1));
        assertArrayEquals(arr2Expected, duplicateZeros.duplicateZeros(arr2));
    }

    @Test
    void duplicateZerosWithAdditionalMemory() {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] arr1Expected = {1, 0, 0, 2, 3, 0, 0, 4};
        int[] arr2 = {8, 4, 5, 0, 0, 0, 0, 7};
        int[] arr2Expected = {8, 4, 5, 0, 0, 0, 0, 0};
        //assertArrayEquals(arr1Expected, duplicateZeros.duplicateZerosWithAdditionalMemory(arr1));
        assertArrayEquals(arr2Expected, duplicateZeros.duplicateZerosWithAdditionalMemory(arr2));
    }

    @Test
    void duplicateZerosSol() {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] arr1Expected = {1, 0, 0, 2, 3, 0, 0, 4};
        int[] arr2 = {8, 4, 5, 0, 0, 0, 0, 7};
        int[] arr2Expected = {8, 4, 5, 0, 0, 0, 0, 0};
        assertArrayEquals(arr1Expected, duplicateZeros.duplicateZerosSol(arr1));
        assertArrayEquals(arr2Expected, duplicateZeros.duplicateZerosSol(arr2));
    }
}