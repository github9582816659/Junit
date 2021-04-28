package com.test.junit.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class StringHelperTest {

    StringHelper helper;

    // @BeforeClass in Junit 4 & @BeforeAll in Junit 5
    @BeforeAll
    static void beforeClass() {
        log.info("Before Class");
    }

    // @AfterClass in Junit 4 & @AfterAll in Junit 5
    @AfterAll
    static void afterClass() {
        log.info("After Class");
    }

    @BeforeEach
    void setup () {
        log.info("Before Test");
        helper = new StringHelper();
    }

    @AfterEach
    void tearDown() {
        log.info("After Test");
        helper = null;
    }

    @Test
    void testTruncateAInFirstTwoPosition() {

        String firstTest = helper.truncateAInFirstTwoPosition("AC");
        assertEquals("C", firstTest);

        String secondTest = helper.truncateAInFirstTwoPosition("AACD");
        assertEquals("CD", secondTest);
    }

    @Test
    void testTruncateAInFirstTwoPosition2() {

        String firstTest = helper.truncateAInFirstTwoPosition("AC");
        assertEquals("C", firstTest);

    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame() {

        boolean result = helper.areFirstAndLastTwoCharactersTheSame("A");
        assertFalse(result);

    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame2() {

        boolean result = helper.areFirstAndLastTwoCharactersTheSame("AB");
        assertTrue(result);

    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame3() {

        boolean result = helper.areFirstAndLastTwoCharactersTheSame("ABAB");
        assertTrue(result);

    }
}
