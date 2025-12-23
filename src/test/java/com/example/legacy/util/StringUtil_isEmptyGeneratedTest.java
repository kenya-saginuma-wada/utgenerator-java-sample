package com.example.legacy.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtil_isEmptyGeneratedTest {

    @Test
    void shouldReturnTrueWhenStringIsNull() {
        // arrange
        String input = null;
        // act
        boolean result = StringUtil.isEmpty(input);
        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhenStringIsEmpty() {
        // arrange
        String input = "";
        // act
        boolean result = StringUtil.isEmpty(input);
        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhenStringIsWhitespace() {
        // arrange
        String input = "   ";
        // act
        boolean result = StringUtil.isEmpty(input);
        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenStringIsNotEmpty() {
        // arrange
        String input = "abc";
        // act
        boolean result = StringUtil.isEmpty(input);
        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenStringHasNonWhitespaceCharacters() {
        // arrange
        String input = " a ";
        // act
        boolean result = StringUtil.isEmpty(input);
        // assert
        assertFalse(result);
    }
}
