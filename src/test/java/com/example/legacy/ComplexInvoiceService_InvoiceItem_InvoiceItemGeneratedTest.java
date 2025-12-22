package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_InvoiceItemGeneratedTest {

    @Test
    void shouldCreateInvoiceItemWithValidInputs() {
        // arrange
        String itemId = "item123";
        String category = "ELECTRONICS";
        double unitPrice = 99.99;
        int quantity = 5;
        boolean isTaxable = true;
        boolean isDiscountable = false;

        // act
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(itemId, item.getItemId());
        assertEquals(category, item.getCategory());
        assertEquals(unitPrice, item.getUnitPrice());
        assertEquals(quantity, item.getQuantity());
        assertEquals(isTaxable, item.isTaxable());
        assertEquals(isDiscountable, item.isDiscountable());
    }

    @Test
    void shouldHandleZeroQuantity() {
        // arrange
        String itemId = "itemZero";
        String category = "BOOKS";
        double unitPrice = 10.0;
        int quantity = 0;
        boolean isTaxable = false;
        boolean isDiscountable = true;

        // act
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(quantity, item.getQuantity());
    }

    @Test
    void shouldHandleNegativeUnitPrice() {
        // arrange
        String itemId = "itemNegative";
        String category = "FOOD";
        double unitPrice = -5.0;
        int quantity = 1;
        boolean isTaxable = true;
        boolean isDiscountable = false;

        // act
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(unitPrice, item.getUnitPrice());
    }

    @Test
    void shouldCreateNonTaxableAndNonDiscountableItem() {
        // arrange
        String itemId = "itemNonTaxNonDisc";
        String category = "CLOTHING";
        double unitPrice = 50.0;
        int quantity = 3;
        boolean isTaxable = false;
        boolean isDiscountable = false;

        // act
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertFalse(item.isTaxable());
        assertFalse(item.isDiscountable());
    }

    @Test
    void shouldCreateTaxableAndDiscountableItem() {
        // arrange
        String itemId = "itemTaxDisc";
        String category = "GIFT";
        double unitPrice = 20.0;
        int quantity = 2;
        boolean isTaxable = true;
        boolean isDiscountable = true;

        // act
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertTrue(item.isTaxable());
        assertTrue(item.isDiscountable());
    }
}
