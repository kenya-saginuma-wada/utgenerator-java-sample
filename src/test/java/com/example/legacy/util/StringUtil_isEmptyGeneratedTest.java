package com.example.legacy.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtil_isEmptyGeneratedTest {

    @Test
    void shouldReturnTrueForNullInput() {
        // arrange
        String input = null;

        // act
        boolean result = StringUtil.isEmpty(input);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForEmptyString() {
        // arrange
        String input = "";

        // act
        boolean result = StringUtil.isEmpty(input);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForStringWithOnlySpaces() {
        // arrange
        String input = "   ";

        // act
        boolean result = StringUtil.isEmpty(input);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForNonEmptyString() {
        // arrange
        String input = "abc";

        // act
        boolean result = StringUtil.isEmpty(input);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForStringWithLeadingAndTrailingSpaces() {
        // arrange
        String input = "  abc  ";

        // act
        boolean result = StringUtil.isEmpty(input);

        // assert
        assertFalse(result);
    }
}
