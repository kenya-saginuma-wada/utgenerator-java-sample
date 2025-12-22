package com.example.legacy.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtil_truncateGeneratedTest {

    @Test
    void shouldReturnNullWhenInputIsNull() {
        // arrange
        String input = null;
        int length = 5;

        // act
        String result = StringUtil.truncate(input, length);

        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnOriginalStringWhenLengthIsGreaterThanStringLength() {
        // arrange
        String input = "hello";
        int length = 10;

        // act
        String result = StringUtil.truncate(input, length);

        // assert
        assertEquals(input, result);
    }

    @Test
    void shouldReturnOriginalStringWhenLengthIsEqualToStringLength() {
        // arrange
        String input = "hello";
        int length = 5;

        // act
        String result = StringUtil.truncate(input, length);

        // assert
        assertEquals(input, result);
    }

    @Test
    void shouldTruncateStringWhenLengthIsLessThanStringLength() {
        // arrange
        String input = "hello world";
        int length = 5;

        // act
        String result = StringUtil.truncate(input, length);

        // assert
        assertEquals("hello", result);
    }

    @Test
    void shouldReturnEmptyStringWhenInputIsEmptyAndLengthIsZero() {
        // arrange
        String input = "";
        int length = 0;

        // act
        String result = StringUtil.truncate(input, length);

        // assert
        assertEquals("", result);
    }
}
