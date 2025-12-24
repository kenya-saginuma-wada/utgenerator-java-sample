package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getQuantityGeneratedTest {

    @Test
    void shouldReturnCorrectQuantity_whenInitializedWithPositiveValue() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item1", "category1", 10.0, 5, true, false);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(5, quantity);
    }

    @Test
    void shouldReturnZero_whenInitializedWithZeroQuantity() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item2", "category2", 15.0, 0, false, true);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(0, quantity);
    }

    @Test
    void shouldReturnNegativeQuantity_whenInitializedWithNegativeValue() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item3", "category3", 20.0, -3, true, true);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(-3, quantity);
    }

    @Test
    void shouldReturnCorrectQuantity_whenInitializedWithLargeValue() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item4", "category4", 25.0, 1000, false, false);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(1000, quantity);
    }
}
