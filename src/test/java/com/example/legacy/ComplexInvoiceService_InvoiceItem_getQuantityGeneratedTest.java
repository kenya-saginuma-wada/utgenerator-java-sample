package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getQuantityGeneratedTest {

    @Test
    void getQuantityShouldReturnCorrectValueWhenPositive() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item1", "category1", 10.0, 5, true, false);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(5, quantity);
    }

    @Test
    void getQuantityShouldReturnZeroWhenZero() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item2", "category2", 20.0, 0, false, true);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(0, quantity);
    }

    @Test
    void getQuantityShouldReturnNegativeValueWhenNegative() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item3", "category3", 30.0, -3, true, true);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(-3, quantity);
    }

    @Test
    void getQuantityShouldReturnMaxIntValue() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item4", "category4", 40.0, Integer.MAX_VALUE, false, false);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(Integer.MAX_VALUE, quantity);
    }

    @Test
    void getQuantityShouldReturnMinIntValue() {
        // arrange
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem("item5", "category5", 50.0, Integer.MIN_VALUE, false, true);

        // act
        int quantity = item.getQuantity();

        // assert
        assertEquals(Integer.MIN_VALUE, quantity);
    }
}
