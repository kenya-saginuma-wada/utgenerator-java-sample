package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getItemIdGeneratedTest {

    @Test
    void getItemIdShouldReturnCorrectIdWhenInitializedWithValidId() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("12345", "ELECTRONICS", 100.0, 2, true, false);

        // act
        String itemId = item.getItemId();

        // assert
        assertEquals("12345", itemId);
    }

    @Test
    void getItemIdShouldReturnEmptyStringWhenInitializedWithEmptyId() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("", "ELECTRONICS", 100.0, 2, true, false);

        // act
        String itemId = item.getItemId();

        // assert
        assertEquals("", itemId);
    }

    @Test
    void getItemIdShouldReturnNullWhenInitializedWithNullId() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(null, "ELECTRONICS", 100.0, 2, true, false);

        // act
        String itemId = item.getItemId();

        // assert
        assertNull(itemId);
    }

    @Test
    void getItemIdShouldReturnCorrectIdForDifferentItem() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("67890", "GROCERIES", 50.0, 5, false, true);

        // act
        String itemId = item.getItemId();

        // assert
        assertEquals("67890", itemId);
    }
}
