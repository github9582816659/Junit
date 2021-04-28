package com.test.junit.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@Slf4j
class ArrayTest {

    // Arrays.sort

    // Testing Arrays
    @Test
    void testArraySort() {
        int[] numbers = {5,4,3,2,1};
        int[] expected = {1,2,3,4,5};

        Arrays.sort(numbers);

        assertArrayEquals(expected,numbers);
    }

    // Testing Exception
    @Test
    void testArraySortException() {
        int[] numbers = null;

        Assertions.assertThrows(NullPointerException.class, () -> {
            Arrays.sort(numbers);
        });
    }

    // Testing Performance
    @Test
    void testArraySortPerformance() {
        int[] numbers = {5,4,3,2,1};

        assertTimeout(Duration.ofMillis(100), () -> {
            for (int i = 1; i <= 1000000; i++) {
                numbers[0] = i;
                numbers[1] = i + 1;

                Arrays.sort(numbers);
            }
        });

    }
}
