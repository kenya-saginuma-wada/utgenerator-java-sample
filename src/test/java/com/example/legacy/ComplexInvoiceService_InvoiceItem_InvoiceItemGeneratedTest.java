package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_InvoiceItemGeneratedTest {

    @Test
    void shouldCreateInvoiceItem_withValidInputs() {
        // arrange
        String itemId = "item123";
        String category = "ELECTRONICS";
        double unitPrice = 299.99;
        int quantity = 5;
        boolean isTaxable = true;
        boolean isDiscountable = true;

        // act
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(itemId, invoiceItem.getItemId());
        assertEquals(category, invoiceItem.getCategory());
        assertEquals(unitPrice, invoiceItem.getUnitPrice());
        assertEquals(quantity, invoiceItem.getQuantity());
        assertTrue(invoiceItem.isTaxable());
        assertTrue(invoiceItem.isDiscountable());
    }

    @Test
    void shouldCreateInvoiceItem_withNonTaxableAndNonDiscountable() {
        // arrange
        String itemId = "item456";
        String category = "FOOD";
        double unitPrice = 19.99;
        int quantity = 10;
        boolean isTaxable = false;
        boolean isDiscountable = false;

        // act
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(itemId, invoiceItem.getItemId());
        assertEquals(category, invoiceItem.getCategory());
        assertEquals(unitPrice, invoiceItem.getUnitPrice());
        assertEquals(quantity, invoiceItem.getQuantity());
        assertFalse(invoiceItem.isTaxable());
        assertFalse(invoiceItem.isDiscountable());
    }

    @Test
    void shouldCreateInvoiceItem_withZeroQuantity() {
        // arrange
        String itemId = "item789";
        String category = "CLOTHING";
        double unitPrice = 49.99;
        int quantity = 0;
        boolean isTaxable = true;
        boolean isDiscountable = true;

        // act
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(itemId, invoiceItem.getItemId());
        assertEquals(category, invoiceItem.getCategory());
        assertEquals(unitPrice, invoiceItem.getUnitPrice());
        assertEquals(quantity, invoiceItem.getQuantity());
        assertTrue(invoiceItem.isTaxable());
        assertTrue(invoiceItem.isDiscountable());
    }

    @Test
    void shouldCreateInvoiceItem_withNegativeUnitPrice() {
        // arrange
        String itemId = "item101";
        String category = "GIFT";
        double unitPrice = -10.00;
        int quantity = 1;
        boolean isTaxable = false;
        boolean isDiscountable = true;

        // act
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(itemId, invoiceItem.getItemId());
        assertEquals(category, invoiceItem.getCategory());
        assertEquals(unitPrice, invoiceItem.getUnitPrice());
        assertEquals(quantity, invoiceItem.getQuantity());
        assertFalse(invoiceItem.isTaxable());
        assertTrue(invoiceItem.isDiscountable());
    }
}
