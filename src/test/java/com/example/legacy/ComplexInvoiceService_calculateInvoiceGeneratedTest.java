package com.example.legacy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComplexInvoiceService_calculateInvoiceGeneratedTest {

    @Test
    void shouldReturnErrorWhenCustomerIsNull() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "category1", 100.0, 1, true, true));
        String regionCode = "US_CA";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(null, items, regionCode, isExpedited, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Customer cannot be null"));
    }

    @Test
    void shouldReturnErrorWhenItemListIsEmpty() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        String regionCode = "US_CA";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Item list cannot be empty"));
    }

    @Test
    void shouldReturnErrorWhenRegionCodeIsInvalid() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "category1", 100.0, 1, true, true));
        String regionCode = "";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Invalid region code"));
    }

    @Test
    void shouldContinueLoopWhenItemQuantityIsInvalid() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "category1", 100.0, 0, true, true)); // Invalid quantity
        items.add(new ComplexInvoiceService.InvoiceItem("item2", "category2", 100.0, 1, true, true)); // Valid item
        String regionCode = "US_CA";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

        // assert
        assertTrue(result.errorMessages.contains("Item item1 (Index: 0) has invalid quantity."));
        assertTrue(result.success); // Should still be true as processing continues
    }

    @Test
    void shouldBreakLoopWhenItemUnitPriceIsNegative() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "category1", -100.0, 1, true, true)); // Negative price
        items.add(new ComplexInvoiceService.InvoiceItem("item2", "category2", 100.0, 1, true, true)); // Valid item
        String regionCode = "US_CA";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Critical Error: Negative price for item item1"));
    }

    @Test
    void shouldCalculateInvoiceForStandardCustomerWithElectronicsOnFriday() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("john.doe@example.com", "John", "Standard");
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item-1", "ELECTRONICS", 200.0, 5, true, true);
        List<ComplexInvoiceService.InvoiceItem> items = List.of(item);
        String regionCode = "US_CA";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 19); // Friday

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(
                customer, items, regionCode, isExpedited, processingDate);

        // assert
        assertNotNull(result);
        assertTrue(result.success);
        assertTrue(result.totalAmount.compareTo(BigDecimal.ZERO) > 0);
        assertNotNull(result.taxAmount);
        assertTrue(result.taxAmount.compareTo(BigDecimal.ZERO) >= 0);
        assertNotNull(result.discountAmount);
        assertTrue(result.discountAmount.compareTo(BigDecimal.ZERO) >= 0);
    }

    @Test
    void shouldCalculateInvoiceForGoldCustomerWithGiftInDecember() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("vip.partner@partner.com", "VIP Gold", "Gold");
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item-2", "GIFT", 1500.0, 1, true, true);
        List<ComplexInvoiceService.InvoiceItem> items = List.of(item);
        String regionCode = "JP";
        boolean isExpedited = true;
        LocalDate processingDate = LocalDate.of(2024, 12, 15); // December

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(
                customer, items, regionCode, isExpedited, processingDate);

        // assert
        assertNotNull(result);
        assertTrue(result.success);
        assertTrue(result.totalAmount.compareTo(BigDecimal.ZERO) > 0);
        assertNotNull(result.taxAmount);
        assertTrue(result.taxAmount.compareTo(BigDecimal.ZERO) >= 0);
        assertNotNull(result.discountAmount);
        assertTrue(result.discountAmount.compareTo(BigDecimal.ZERO) >= 0);
    }

    @Test
    void shouldCalculateInvoiceForSilverCustomerWithBulkDiscount() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("vip.silver@example.com", "VIP Silver", "Silver");
        ComplexInvoiceService.InvoiceItem item = new ComplexInvoiceService.InvoiceItem(
                "item-3", "OFFICE", 100.0, 20, true, true);
        List<ComplexInvoiceService.InvoiceItem> items = List.of(item);
        String regionCode = "EU_DE";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 3, 10);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(
                customer, items, regionCode, isExpedited, processingDate);

        // assert
        assertNotNull(result);
        assertTrue(result.success);
        assertTrue(result.totalAmount.compareTo(BigDecimal.ZERO) > 0);
        assertNotNull(result.taxAmount);
        assertTrue(result.taxAmount.compareTo(BigDecimal.ZERO) >= 0);
        assertNotNull(result.discountAmount);
        assertTrue(result.discountAmount.compareTo(BigDecimal.ZERO) >= 0);
    }

    @Test
    void shouldHandleNegativeUnitPriceGracefully() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("john.doe@example.com", "John", "Standard");
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "ELECTRONICS", -100.0, 1, true, true));
        String regionCode = "US_CA";
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, false, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Critical Error: Negative price for item item1"));
    }

    @Test
    void shouldApplyMaxDiscountLimit() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("vip.customer@partner.com", "VIP Customer", "VIP");
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "ELECTRONICS", 1000.0, 10, true, true));
        String regionCode = "JP";
        LocalDate processingDate = LocalDate.of(2024, 12, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, false, processingDate);

        // assert
        assertTrue(result.success);
        assertNotNull(result.discountAmount);
        assertTrue(result.discountAmount.compareTo(new BigDecimal("5000.00")) <= 0); // Max discount should not exceed 50%
    }

    @Test
    void shouldHandleZeroQuantityGracefully() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("jane.doe@example.com", "Jane", "Standard");
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "CLOTHING", 100.0, 0, true, true));
        String regionCode = "US_NY";
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, false, processingDate);

        // assert
        assertTrue(result.success);
        assertTrue(result.errorMessages.contains("Item item1 (Index: 0) has invalid quantity."));
    }

}