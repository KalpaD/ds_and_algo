package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatedCharTest {

    private FirstNonRepeatedChar firstNonRepeatedChar;

    @BeforeEach
    void setUp() {
        firstNonRepeatedChar = new FirstNonRepeatedChar();
    }

    @ParameterizedTest
    @CsvSource({
            "total, o",
            "teeter, r",
    })
    void findFirstNonRepeated(String input, char output) {

        assertEquals(output, firstNonRepeatedChar.findFirstNonRepeated(input));
    }

    @Test
    void findFirstNonRepeatedForNoAnswer() {
        String input = "teeterr";
        assertThrows(NoSuchElementException.class, () -> firstNonRepeatedChar.findFirstNonRepeated(input));
    }
}