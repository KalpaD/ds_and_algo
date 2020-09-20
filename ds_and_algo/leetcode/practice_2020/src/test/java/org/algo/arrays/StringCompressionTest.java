package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    private StringCompression compression;

    @BeforeEach
    void setUp() {
        compression = new StringCompression();
    }

    @Test
    void compress() {

        assertEquals( "a2b1c5a3",compression.compress("aabcccccaaa"));
    }
}