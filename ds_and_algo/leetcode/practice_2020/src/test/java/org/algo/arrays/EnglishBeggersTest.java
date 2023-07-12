package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EnglishBeggersTest {

    private EnglishBeggers englishBeggers;

    @BeforeEach
    void setUp() {
        englishBeggers = new EnglishBeggers();
    }


    @Test
    void testEnglishBegers() {
        int[] test = {1, 2, 3, 4, 5};
        int [] expected = {15};
        int[] actual = englishBeggers.beggars(test, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testEnglishBegers2() {
        int[] test = {1, 2, 3, 4, 5};
        int [] expected = {9, 6};
        int[] actual = englishBeggers.beggars(test, 2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testEnglishBegers3() {
        int[] test = {1, 2, 3, 4, 5};
        int [] expected = {5, 7, 3};
        int[] actual = englishBeggers.beggars(test, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testEnglishBegers6() {
        int[] test = {1, 2, 3, 4, 5};
        int [] expected = {1, 2, 3, 4, 5, 0};
        int[] actual = englishBeggers.beggars(test, 6);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testEnglishBegers0() {
        int[] test = {1, 2, 3, 4, 5};
        int [] expected = {};
        int[] actual = englishBeggers.beggars(test, 0);
        assertArrayEquals(expected, actual);
    }
}