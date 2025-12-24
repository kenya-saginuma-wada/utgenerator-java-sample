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
    void shouldFailWhenCustomerIsNull() {
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
    void shouldFailWhenItemsListIsNull() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        String regionCode = "US_CA";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, null, regionCode, isExpedited, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Item list cannot be empty"));
    }

    @Test
    void shouldFailWhenItemsListIsEmpty() {
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
    void shouldFailWhenRegionCodeIsNull() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "category1", 100.0, 1, true, true));
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, null, isExpedited, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Invalid region code"));
    }

    @Test
    void shouldFailWhenRegionCodeIsEmpty() {
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
    void calculateInvoice_successForStandardCustomer() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("john.doe@example.com", "John", "Standard");
        List<ComplexInvoiceService.InvoiceItem> items = List.of(
                new ComplexInvoiceService.InvoiceItem("item1", "ELECTRONICS", 100.0, 5, true, true)
        );
        String regionCode = "US_CA";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

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
    void calculateInvoice_successForGoldCustomerWithExpeditedShipping() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("vip.partner@partner.com", "VIP Customer", "Gold");
        List<ComplexInvoiceService.InvoiceItem> items = List.of(
                new ComplexInvoiceService.InvoiceItem("item2", "GIFT", 200.0, 15, true, true)
        );
        String regionCode = "JP";
        boolean isExpedited = true;
        LocalDate processingDate = LocalDate.of(2024, 12, 20);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

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
    void calculateInvoice_successForSilverCustomerWithBulkDiscount() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("silver.customer@example.com", "VIP Silver", "Silver");
        List<ComplexInvoiceService.InvoiceItem> items = List.of(
                new ComplexInvoiceService.InvoiceItem("item3", "FOOD", 50.0, 20, true, true)
        );
        String regionCode = "EU_DE";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 6, 10);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

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
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "ELECTRONICS", -50.0, 1, true, true));
        String regionCode = "US_CA";
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, false, processingDate);

        // assert
        assertFalse(result.success);
        assertTrue(result.errorMessages.contains("Critical Error: Negative price for item item1"));
    }

    @Test
    void shouldContinueProcessingWithZeroQuantityItem() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("jane.doe@example.com", "Jane", "Standard");
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "ELECTRONICS", 100.0, 0, true, true));
        items.add(new ComplexInvoiceService.InvoiceItem("item2", "ELECTRONICS", 100.0, 1, true, true));
        String regionCode = "US_CA";
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, false, processingDate);

        // assert
        assertTrue(result.success);
        assertTrue(result.errorMessages.contains("Item item1 (Index: 0) has invalid quantity."));
        assertNotNull(result.totalAmount);
    }

    @Test
    void shouldApplyCorrectTaxForRegionCodeJP() {
        // arrange
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("vip.customer@partner.com", "VIP Customer", "Gold");
        List<ComplexInvoiceService.InvoiceItem> items = new ArrayList<>();
        items.add(new ComplexInvoiceService.InvoiceItem("item1", "FOOD", 100.0, 1, true, true));
        String regionCode = "JP";
        LocalDate processingDate = LocalDate.of(2024, 1, 15);

        // act
        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, false, processingDate);

        // assert
        assertTrue(result.success);
        assertNotNull(result.taxAmount);
        assertEquals(0, result.taxAmount.compareTo(new BigDecimal("8.00"))); // 8% tax for FOOD in JP
    }

}