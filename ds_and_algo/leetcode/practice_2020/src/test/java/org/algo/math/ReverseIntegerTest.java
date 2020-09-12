package org.algo.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {

    private ReverseInteger reverseInteger;

    @BeforeEach
    public void setUp() {
        reverseInteger = new ReverseInteger();
    }

    @ParameterizedTest
    @CsvSource({
            "123, 321",
            "-123, -321",
            "120, 21",
            "900000, 9",
    })
    public void testForSampleInputs(int input, int output) {
        assertEquals(output, reverseInteger.reverse(input));
    }

}
