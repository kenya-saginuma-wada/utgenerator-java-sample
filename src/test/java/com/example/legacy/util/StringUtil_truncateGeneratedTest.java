package com.example.legacy.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtil_truncateGeneratedTest {

    @Test
    void shouldReturnNullWhenInputIsNull() {
        // arrange
        StringUtil stringUtil = new StringUtil();
        String input = null;
        int length = 5;

        // act
        String result = stringUtil.truncate(input, length);

        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnOriginalStringWhenLengthIsGreaterThanStringLength() {
        // arrange
        StringUtil stringUtil = new StringUtil();
        String input = "Hello";
        int length = 10;

        // act
        String result = stringUtil.truncate(input, length);

        // assert
        assertEquals(input, result);
    }

    @Test
    void shouldReturnOriginalStringWhenLengthIsEqualToStringLength() {
        // arrange
        StringUtil stringUtil = new StringUtil();
        String input = "Hello";
        int length = 5;

        // act
        String result = stringUtil.truncate(input, length);

        // assert
        assertEquals(input, result);
    }

    @Test
    void shouldReturnTruncatedStringWhenLengthIsLessThanStringLength() {
        // arrange
        StringUtil stringUtil = new StringUtil();
        String input = "Hello, World!";
        int length = 5;

        // act
        String result = stringUtil.truncate(input, length);

        // assert
        assertEquals("Hello", result);
    }
}
