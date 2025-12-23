package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getItemIdGeneratedTest {

    @Test
    void shouldReturnCorrectItemId_whenValidItemIdProvided() {
        // arrange
        String expectedItemId = "item123";
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                expectedItemId, "category", 100.0, 2, true, false);

        // act
        String actualItemId = item.getItemId();

        // assert
        assertEquals(expectedItemId, actualItemId);
    }

    @Test
    void shouldReturnNonNullItemId_whenItemIdIsNonEmpty() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "nonEmptyId", "category", 50.0, 1, false, true);

        // act
        String itemId = item.getItemId();

        // assert
        assertNotNull(itemId);
    }

    @Test
    void shouldReturnEmptyItemId_whenItemIdIsEmptyString() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "", "category", 75.0, 3, true, true);

        // act
        String itemId = item.getItemId();

        // assert
        assertEquals("", itemId);
    }

    @Test
    void shouldReturnItemId_whenItemIdContainsSpecialCharacters() {
        // arrange
        String expectedItemId = "item@#123";
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                expectedItemId, "category", 200.0, 5, false, false);

        // act
        String actualItemId = item.getItemId();

        // assert
        assertEquals(expectedItemId, actualItemId);
    }
}
