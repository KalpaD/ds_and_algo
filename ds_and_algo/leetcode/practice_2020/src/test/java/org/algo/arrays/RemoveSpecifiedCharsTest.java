package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveSpecifiedCharsTest {

    private RemoveSpecifiedChars removeSpecifiedChars;

    @BeforeEach
    void setUp() {
        removeSpecifiedChars = new RemoveSpecifiedChars();
    }

    @Test
    void removeChars() {
        assertEquals("Bttl f th Vwls: Hw vs. Grzny",
                removeSpecifiedChars.removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
    }
}