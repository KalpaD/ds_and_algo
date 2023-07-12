package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationsTest {

    private PalindromePermutations palindromePermutations;

    @BeforeEach
    void setUp() {
        palindromePermutations = new PalindromePermutations();
    }

    @Test
    void isPalindromePermutation() {
        String s = "Tact Coa";
        assertTrue(palindromePermutations.isPalindromePermutation(s));
        assertTrue(palindromePermutations.isPalindromePermutation2(s));
    }

    @Test
    void isPalindromePermutation2() {
        String s = "Ra ora";
        assertTrue(palindromePermutations.isPalindromePermutation(s));
        assertTrue(palindromePermutations.isPalindromePermutation2(s));
    }


    @Test
    void isPalindromePermutation3() {
        String s = "Rats on evil live no star";
        assertTrue(palindromePermutations.isPalindromePermutation(s));
        assertTrue(palindromePermutations.isPalindromePermutation2(s));
    }

}