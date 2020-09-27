package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxConsecutiveOnesTest {

    private MaxConsecutiveOnes maxConsecutiveOnes;

    @BeforeEach
    void setUp() {
        maxConsecutiveOnes = new MaxConsecutiveOnes();
    }

    @Test
    void findMaxConsecutiveOnes() {
        assertEquals(1, maxConsecutiveOnes.findMaxConsecutiveOnes(new int[] {1}));
    }
}