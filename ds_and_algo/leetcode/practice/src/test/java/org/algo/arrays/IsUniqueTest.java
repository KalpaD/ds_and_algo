package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {

    private IsUnique isUnique;

    @BeforeEach
    public void setUp() {
        isUnique = new IsUnique();
    }

    @Test
    void isUnique() {
        assertTrue(isUnique.isUnique("abcdefg"));
    }

    @Test
    void isUniqueFalse() {
        assertFalse(isUnique.isUnique("abbcdefg"));
    }
}