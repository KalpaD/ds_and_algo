package org.algo.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeNumberTest {

    private PalindromeNumber palindromeNumber;

    @BeforeEach
    public void setUp() {
        palindromeNumber = new PalindromeNumber();
    }

    @Test
    public void test() {

        assertTrue(palindromeNumber.isPalindromeImproved(1221));
        assertFalse(palindromeNumber.isPalindrome(-121));
        assertFalse(palindromeNumber.isPalindrome(10));
        assertFalse(palindromeNumber.isPalindrome(64));

    }
}
