package org.algo.arrays;

import org.algo.math.PalindromeNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsValidSubSequenceTest {

    private IsValidSubSequence isValidSubSequence;

    @BeforeEach
    public void setUp() {
        isValidSubSequence = new IsValidSubSequence();
    }

    @Test
    public void test1() {
        List<Integer> list1 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> list2 = Arrays.asList(1, 6, -1, 10);
        assertTrue(isValidSubSequence.isValidSubsequence(list1, list2));
    }

    @Test
    public void test2() {
        List<Integer> list1 = Arrays.asList(5);
        List<Integer> list2 = Arrays.asList(5);
        assertTrue(isValidSubSequence.isValidSubsequence(list1, list2));
    }

    @Test
    public void test3() {
        List<Integer> list1 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> list2 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        assertTrue(isValidSubSequence.isValidSubsequence(list1, list2));
    }

    @Test
    public void test4() {
        List<Integer> list1 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> list2 = Arrays.asList(5);
        assertTrue(isValidSubSequence.isValidSubsequence(list1, list2));
    }
}
