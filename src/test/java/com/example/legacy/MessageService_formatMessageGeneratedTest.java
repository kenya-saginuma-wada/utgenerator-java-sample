package com.example.legacy;


import com.example.legacy.util.StringUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageService_formatMessageGeneratedTest {

    @Test
    void shouldReturnEmptyStringWhenBodyIsEmpty() {
        // arrange
        var messageService = new MessageService();
        var prefix = "Test";
        var body = "";

        try (var mockedStatic = mockStatic(StringUtil.class)) {
            mockedStatic.when(() -> StringUtil.isEmpty(body)).thenReturn(true);

            // act
            var result = messageService.formatMessage(prefix, body);

            // assert
            assertEquals("", result);
        }
    }

    @Test
    void shouldUseDefaultPrefixWhenPrefixIsEmpty() {
        // arrange
        var messageService = new MessageService();
        var prefix = "";
        var body = "Hello World";

        try (var mockedStatic = mockStatic(StringUtil.class)) {
            mockedStatic.when(() -> StringUtil.isEmpty(body)).thenReturn(false);
            mockedStatic.when(() -> StringUtil.isEmpty(prefix)).thenReturn(true);
            mockedStatic.when(() -> StringUtil.truncate(body, 100)).thenReturn(body);

            // act
            var result = messageService.formatMessage(prefix, body);

            // assert
            assertEquals("MSG: Hello World", result);
        }
    }

    @Test
    void shouldUseUpperCasePrefixWhenPrefixIsNotEmpty() {
        // arrange
        var messageService = new MessageService();
        var prefix = "info";
        var body = "Hello World";

        try (var mockedStatic = mockStatic(StringUtil.class)) {
            mockedStatic.when(() -> StringUtil.isEmpty(body)).thenReturn(false);
            mockedStatic.when(() -> StringUtil.isEmpty(prefix)).thenReturn(false);
            mockedStatic.when(() -> StringUtil.toUpperCase(prefix)).thenReturn("INFO");
            mockedStatic.when(() -> StringUtil.truncate(body, 100)).thenReturn(body);

            // act
            var result = messageService.formatMessage(prefix, body);

            // assert
            assertEquals("INFO: Hello World", result);
        }
    }

    @Test
    void shouldTruncateBodyWhenExceedsLimit() {
        // arrange
        var messageService = new MessageService();
        var prefix = "info";
        var body = "This is a very long message that should be truncated to fit within the limit of 100 characters.";

        try (var mockedStatic = mockStatic(StringUtil.class)) {
            mockedStatic.when(() -> StringUtil.isEmpty(body)).thenReturn(false);
            mockedStatic.when(() -> StringUtil.isEmpty(prefix)).thenReturn(false);
            mockedStatic.when(() -> StringUtil.toUpperCase(prefix)).thenReturn("INFO");
            mockedStatic.when(() -> StringUtil.truncate(body, 100)).thenReturn("This is a very long message that should be truncated to fit within the limit of 100 charact");

            // act
            var result = messageService.formatMessage(prefix, body);

            // assert
            assertEquals("INFO: This is a very long message that should be truncated to fit within the limit of 100 charact", result);
        }
    }
}
