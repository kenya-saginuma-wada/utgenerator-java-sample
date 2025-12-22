package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getUnitPriceGeneratedTest {

    @Test
    void getUnitPriceShouldReturnCorrectValueForPositivePrice() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item1", "category1", 100.0, 1, true, true);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(100.0, unitPrice);
    }

    @Test
    void getUnitPriceShouldReturnCorrectValueForZeroPrice() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item2", "category2", 0.0, 1, false, false);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(0.0, unitPrice);
    }

    @Test
    void getUnitPriceShouldReturnCorrectValueForNegativePrice() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item3", "category3", -50.0, 1, false, true);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(-50.0, unitPrice);
    }

    @Test
    void getUnitPriceShouldReturnCorrectValueForHighPrecisionPrice() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item4", "category4", 123.456789, 1, true, false);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(123.456789, unitPrice);
    }

    @Test
    void getUnitPriceShouldReturnCorrectValueForLargePrice() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item5", "category5", 1_000_000.0, 1, true, true);

        // act
        double unitPrice = item.getUnitPrice();

        // assert
        assertEquals(1_000_000.0, unitPrice);
    }
}
