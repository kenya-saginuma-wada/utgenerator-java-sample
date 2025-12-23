package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getQuantityGeneratedTest {

    @Test
    void shouldReturnCorrectQuantity_whenValidQuantityProvided() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item1", "category1", 10.0, 5, true, false);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(5, quantity);
    }

    @Test
    void shouldReturnZero_whenZeroQuantityProvided() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item2", "category2", 20.0, 0, false, true);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(0, quantity);
    }

    @Test
    void shouldReturnNegativeQuantity_whenNegativeQuantityProvided() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item3", "category3", 30.0, -10, true, true);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(-10, quantity);
    }

    @Test
    void shouldReturnLargeQuantity_whenLargeQuantityProvided() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item4", "category4", 40.0, 100000, false, false);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(100000, quantity);
    }

    @Test
    void shouldReturnOne_whenOneQuantityProvided() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item5", "category5", 50.0, 1, true, false);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(1, quantity);
    }
}
