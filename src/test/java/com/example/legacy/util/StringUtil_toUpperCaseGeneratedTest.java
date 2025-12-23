package com.example.legacy.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtil_toUpperCaseGeneratedTest {

    @Test
    void shouldReturnNullWhenInputIsNull() {
        // arrange
        String input = null;
        StringUtil stringUtil = new StringUtil();

        // act
        String result = stringUtil.toUpperCase(input);

        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnUpperCaseWhenInputIsLowerCase() {
        // arrange
        String input = "hello";
        StringUtil stringUtil = new StringUtil();

        // act
        String result = stringUtil.toUpperCase(input);

        // assert
        assertEquals("HELLO", result);
    }

    @Test
    void shouldReturnUpperCaseWhenInputIsMixedCase() {
        // arrange
        String input = "HeLLo WoRLd";
        StringUtil stringUtil = new StringUtil();

        // act
        String result = stringUtil.toUpperCase(input);

        // assert
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void shouldReturnSameStringWhenInputIsAlreadyUpperCase() {
        // arrange
        String input = "HELLO";
        StringUtil stringUtil = new StringUtil();

        // act
        String result = stringUtil.toUpperCase(input);

        // assert
        assertEquals("HELLO", result);
    }

    @Test
    void shouldReturnEmptyStringWhenInputIsEmpty() {
        // arrange
        String input = "";
        StringUtil stringUtil = new StringUtil();

        // act
        String result = stringUtil.toUpperCase(input);

        // assert
        assertEquals("", result);
    }
}
