package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPermutationTest {

    private CheckPermutation checkPermutation;

    @BeforeEach
    public void setUp() {
        checkPermutation = new CheckPermutation();
    }

    @Test
    public void test1() {
        String s = "acdbef";
        String p = "bcdafe";
        assertTrue(checkPermutation.isPermutation(s, p));
    }

    @Test
    public void test2() {
        String s = "acdbef";
        String p = "bcdaf";
        assertFalse(checkPermutation.isPermutation(s, p));
    }


}
