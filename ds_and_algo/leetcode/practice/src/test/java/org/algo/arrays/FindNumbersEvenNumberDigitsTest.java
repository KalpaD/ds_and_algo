package org.algo.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNumbersEvenNumberDigitsTest {

    private FindNumbersEvenNumberDigits findNumbersEvenNumberDigits;

    @BeforeEach
    void setUp() {
        findNumbersEvenNumberDigits = new FindNumbersEvenNumberDigits();
    }

    @Test
    void findNumbers() {
        int [] nums = { 555,901,482,1771 };
        findNumbersEvenNumberDigits.findNumbers(nums);
    }
}