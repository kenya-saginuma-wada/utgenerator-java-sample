package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getUnitPriceGeneratedTest {

    @Test
    void shouldReturnCorrectUnitPrice_whenValidInput() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item1", "category1", 100.0, 5, true, true);

        // act
        double result = item.getUnitPrice();

        // assert
        assertEquals(100.0, result);
    }

    @Test
    void shouldReturnZeroUnitPrice_whenUnitPriceIsZero() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item2", "category2", 0.0, 10, false, false);

        // act
        double result = item.getUnitPrice();

        // assert
        assertEquals(0.0, result);
    }

    @Test
    void shouldReturnNegativeUnitPrice_whenUnitPriceIsNegative() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item3", "category3", -50.0, 2, true, false);

        // act
        double result = item.getUnitPrice();

        // assert
        assertEquals(-50.0, result);
    }

    @Test
    void shouldReturnCorrectUnitPrice_whenUnitPriceIsDecimal() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item4", "category4", 99.99, 1, false, true);

        // act
        double result = item.getUnitPrice();

        // assert
        assertEquals(99.99, result);
    }
}
