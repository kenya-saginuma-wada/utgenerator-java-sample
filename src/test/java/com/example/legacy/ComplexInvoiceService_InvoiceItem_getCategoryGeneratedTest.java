package com.example.legacy;

import com.example.legacy.ComplexInvoiceService.InvoiceItem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexInvoiceService_InvoiceItem_getCategoryGeneratedTest {

    @Test
    void getCategoryShouldReturnAssignedCategory() {
        // arrange
        var invoiceItem = new ComplexInvoiceService.InvoiceItem("item1", "ELECTRONICS", 100.0, 2, true, true);

        // act
        String category = invoiceItem.getCategory();

        // assert
        assertEquals("ELECTRONICS", category);
    }

    @Test
    void getCategoryShouldReturnEmptyStringWhenCategoryIsEmpty() {
        // arrange
        var invoiceItem = new ComplexInvoiceService.InvoiceItem("item2", "", 50.0, 1, false, false);

        // act
        String category = invoiceItem.getCategory();

        // assert
        assertEquals("", category);
    }

    @Test
    void getCategoryShouldReturnNullWhenCategoryIsNull() {
        // arrange
        var invoiceItem = new ComplexInvoiceService.InvoiceItem("item3", null, 75.0, 3, true, false);

        // act
        String category = invoiceItem.getCategory();

        // assert
        assertNull(category);
    }

    @Test
    void getCategoryShouldReturnCorrectCategoryForDifferentItem() {
        // arrange
        var invoiceItem = new ComplexInvoiceService.InvoiceItem("item4", "FOOD", 20.0, 5, false, true);

        // act
        String category = invoiceItem.getCategory();

        // assert
        assertEquals("FOOD", category);
    }
}
