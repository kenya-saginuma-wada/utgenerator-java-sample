package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getUnitPriceGeneratedTest {

    @Test
    void shouldReturnCorrectUnitPrice_whenValidInput() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item1", "category1", 99.99, 10, true, false);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(99.99, unitPrice);
    }

    @Test
    void shouldReturnZeroUnitPrice_whenZeroPriceInput() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item2", "category2", 0.0, 5, false, true);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(0.0, unitPrice);
    }

    @Test
    void shouldReturnNegativeUnitPrice_whenNegativePriceInput() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item3", "category3", -50.0, 3, true, true);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(-50.0, unitPrice);
    }

    @Test
    void shouldReturnCorrectUnitPrice_whenHighPrecisionPriceInput() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item4", "category4", 123.456789, 7, false, false);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(123.456789, unitPrice);
    }

    @Test
    void shouldReturnCorrectUnitPrice_whenSmallFractionalPriceInput() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item5", "category5", 0.0001, 1, false, true);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(0.0001, unitPrice);
    }
}
