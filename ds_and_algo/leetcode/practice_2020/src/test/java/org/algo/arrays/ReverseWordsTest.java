package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

    private ReverseWords reverseWords;

    @BeforeEach
    void setUp() {
        reverseWords = new ReverseWords();
    }

    @Test
    void reverse() {
        String s = "Do or do not, there is no try.";
        assertEquals("try. no is there not, do or Do", reverseWords.reverse(s));
    }

    @Test
    void reverse2() {
        String s = "Do or do not, there is no try.";
        assertEquals("try. no is there not, do or Do", reverseWords.reverseUsingCharArray(s));
    }
}