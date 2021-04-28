package com.test.junit.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class StringHelperParameterizedTest {

    StringHelper helper;

    @BeforeEach
    void setup () {
        helper = new StringHelper();
    }

    @AfterEach
    void tearDown() {
        helper = null;
    }

    // https://www.baeldung.com/parameterized-tests-junit-5
    @ParameterizedTest
    @CsvSource({"AC,C", "AACD,CD"})
    void testTruncateAInFirstTwoPosition(String input, String expected) {

        assertEquals(expected, helper.truncateAInFirstTwoPosition(input));

    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCD", "A"})
    void testAreFirstAndLastTwoCharactersTheSame_Return_False(String input) {

        boolean result = helper.areFirstAndLastTwoCharactersTheSame(input);
        assertFalse(result);

    }

    @ParameterizedTest
    @ValueSource(strings = {"ABAB", "AB"})
    void testAreFirstAndLastTwoCharactersTheSame_Return_True(String input) {

        boolean result = helper.areFirstAndLastTwoCharactersTheSame(input);
        assertTrue(result);

    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame3() {

        boolean result = helper.areFirstAndLastTwoCharactersTheSame("ABAB");
        assertTrue(result);

    }
}
