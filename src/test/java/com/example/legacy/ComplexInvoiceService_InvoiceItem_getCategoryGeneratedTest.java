package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getCategoryGeneratedTest {

    @Test
    void shouldReturnCategory_whenCategoryIsSet() {
        // arrange
        var item = new ComplexInvoiceService.InvoiceItem("item1", "ELECTRONICS", 100.0, 5, true, true);

        // act
        var category = item.getCategory();

        // assert
        assertEquals("ELECTRONICS", category);
    }

    @Test
    void shouldReturnCategory_whenCategoryIsGift() {
        // arrange
        var item = new ComplexInvoiceService.InvoiceItem("item2", "GIFT", 200.0, 2, false, true);

        // act
        var category = item.getCategory();

        // assert
        assertEquals("GIFT", category);
    }

    @Test
    void shouldReturnCategory_whenCategoryIsFood() {
        // arrange
        var item = new ComplexInvoiceService.InvoiceItem("item3", "FOOD", 50.0, 10, true, false);

        // act
        var category = item.getCategory();

        // assert
        assertEquals("FOOD", category);
    }

    @Test
    void shouldReturnCategory_whenCategoryIsClothing() {
        // arrange
        var item = new ComplexInvoiceService.InvoiceItem("item4", "CLOTHING", 75.0, 3, true, true);

        // act
        var category = item.getCategory();

        // assert
        assertEquals("CLOTHING", category);
    }

    @Test
    void shouldReturnCategory_whenCategoryIsNull() {
        // arrange
        var item = new ComplexInvoiceService.InvoiceItem("item5", null, 120.0, 1, false, false);

        // act
        var category = item.getCategory();

        // assert
        assertNull(category);
    }
}
