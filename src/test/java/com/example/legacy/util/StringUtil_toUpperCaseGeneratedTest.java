package com.example.legacy.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtil_toUpperCaseGeneratedTest {

    @Test
    void shouldReturnNullWhenInputIsNull() {
        // arrange
        String input = null;

        // act
        String result = StringUtil.toUpperCase(input);

        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnUpperCaseWhenInputIsLowerCase() {
        // arrange
        String input = "hello";

        // act
        String result = StringUtil.toUpperCase(input);

        // assert
        assertEquals("HELLO", result);
    }

    @Test
    void shouldReturnSameStringWhenInputIsAlreadyUpperCase() {
        // arrange
        String input = "WORLD";

        // act
        String result = StringUtil.toUpperCase(input);

        // assert
        assertEquals("WORLD", result);
    }

    @Test
    void shouldHandleMixedCaseInput() {
        // arrange
        String input = "HeLLo WoRLd";

        // act
        String result = StringUtil.toUpperCase(input);

        // assert
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void shouldHandleEmptyString() {
        // arrange
        String input = "";

        // act
        String result = StringUtil.toUpperCase(input);

        // assert
        assertEquals("", result);
    }
}
