package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getItemIdGeneratedTest {

    @Test
    void shouldReturnCorrectItemId_whenValidItemIdProvided() {
        // arrange
        String expectedItemId = "item123";
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                expectedItemId, "category", 10.0, 1, true, false);

        // act
        String actualItemId = invoiceItem.getItemId();

        // assert
        assertEquals(expectedItemId, actualItemId);
    }

    @Test
    void shouldReturnNonNullItemId_whenItemIdIsEmptyString() {
        // arrange
        String expectedItemId = "";
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                expectedItemId, "category", 10.0, 1, true, false);

        // act
        String actualItemId = invoiceItem.getItemId();

        // assert
        assertNotNull(actualItemId);
        assertEquals(expectedItemId, actualItemId);
    }

    @Test
    void shouldReturnNonNullItemId_whenItemIdIsNull() {
        // arrange
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                null, "category", 10.0, 1, true, false);

        // act
        String actualItemId = invoiceItem.getItemId();

        // assert
        assertNull(actualItemId);
    }

    @Test
    void shouldReturnCorrectItemId_whenItemIdContainsSpecialCharacters() {
        // arrange
        String expectedItemId = "item@#123";
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                expectedItemId, "category", 10.0, 1, true, false);

        // act
        String actualItemId = invoiceItem.getItemId();

        // assert
        assertEquals(expectedItemId, actualItemId);
    }

    @Test
    void shouldReturnCorrectItemId_whenItemIdContainsWhitespace() {
        // arrange
        String expectedItemId = "item 123";
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                expectedItemId, "category", 10.0, 1, true, false);

        // act
        String actualItemId = invoiceItem.getItemId();

        // assert
        assertEquals(expectedItemId, actualItemId);
    }
}
