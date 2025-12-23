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
        boolean isDiscountable = false;

        // act
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(itemId, invoiceItem.getItemId());
        assertEquals(category, invoiceItem.getCategory());
        assertEquals(unitPrice, invoiceItem.getUnitPrice());
        assertEquals(quantity, invoiceItem.getQuantity());
        assertEquals(isTaxable, invoiceItem.isTaxable());
        assertEquals(isDiscountable, invoiceItem.isDiscountable());
    }

    @Test
    void shouldCreateInvoiceItem_withZeroQuantity() {
        // arrange
        String itemId = "item124";
        String category = "GROCERY";
        double unitPrice = 19.99;
        int quantity = 0;
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
        assertEquals(isTaxable, invoiceItem.isTaxable());
        assertEquals(isDiscountable, invoiceItem.isDiscountable());
    }

    @Test
    void shouldCreateInvoiceItem_withNegativePrice() {
        // arrange
        String itemId = "item125";
        String category = "CLOTHING";
        double unitPrice = -10.00;
        int quantity = 3;
        boolean isTaxable = true;
        boolean isDiscountable = false;

        // act
        ComplexInvoiceService.InvoiceItem invoiceItem = new ComplexInvoiceService.InvoiceItem(
                itemId, category, unitPrice, quantity, isTaxable, isDiscountable);

        // assert
        assertEquals(itemId, invoiceItem.getItemId());
        assertEquals(category, invoiceItem.getCategory());
        assertEquals(unitPrice, invoiceItem.getUnitPrice());
        assertEquals(quantity, invoiceItem.getQuantity());
        assertEquals(isTaxable, invoiceItem.isTaxable());
        assertEquals(isDiscountable, invoiceItem.isDiscountable());
    }

    @Test
    void shouldCreateInvoiceItem_withHighQuantity() {
        // arrange
        String itemId = "item126";
        String category = "OFFICE_SUPPLIES";
        double unitPrice = 1.50;
        int quantity = 100;
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
        assertEquals(isTaxable, invoiceItem.isTaxable());
        assertEquals(isDiscountable, invoiceItem.isDiscountable());
    }

    @Test
    void shouldCreateInvoiceItem_withNonDiscountableAndNonTaxable() {
        // arrange
        String itemId = "item127";
        String category = "BOOKS";
        double unitPrice = 15.00;
        int quantity = 2;
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
        assertEquals(isTaxable, invoiceItem.isTaxable());
        assertEquals(isDiscountable, invoiceItem.isDiscountable());
    }
}
