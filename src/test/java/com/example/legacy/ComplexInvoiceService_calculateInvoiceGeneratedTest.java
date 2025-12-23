/*
 * ⚠️ UTGenerator WARNING: This test failed during generation execution.
 * Manual intervention is required. The test has been disabled.
 *
 * Last Error:
 * 
 * 122 tests completed, 1 failed
 * 
 * FAILURE: Build failed with an exception.
 * 
 * * What went wrong:
 * Execution failed for task ':test'.
 * > There were failing tests. See the report at: file:///tmp/utgen_iso_ComplexInvoiceService_calculateInvoiceGeneratedTest_20251223_234056_13628348903956688435/build/reports/tests/test/index.html
 * 
 * * Try:
 */
package com.example.legacy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("Generated test failed execution")
class ComplexInvoiceServiceTest {

    @Test
    void calculateInvoice_basicFunctionality() {
        ComplexInvoiceService service = new ComplexInvoiceService();
        SimpleCustomerData customer = new SimpleCustomerData("email@example.com", "John", "123");
        List<ComplexInvoiceService.InvoiceItem> items = List.of(
                new ComplexInvoiceService.InvoiceItem("item1", "CATEGORY", 10.0, 1, false, false)
        );
        String regionCode = "US";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 1);

        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(customer, items, regionCode, isExpedited, processingDate);

        assertNotNull(result);
        assertEquals(true, result.success);
        assertEquals(new BigDecimal("10.00"), result.totalAmount);
    }

    @Test
    void calculateInvoice_nullCustomer() {
        ComplexInvoiceService service = new ComplexInvoiceService();
        List<ComplexInvoiceService.InvoiceItem> items = List.of(
                new ComplexInvoiceService.InvoiceItem("item1", "CATEGORY", 10.0, 1, false, false)
        );
        String regionCode = "US";
        boolean isExpedited = false;
        LocalDate processingDate = LocalDate.of(2024, 1, 1);

        ComplexInvoiceService.CalculationResult result = service.calculateInvoice(null, items, regionCode, isExpedited, processingDate);

        assertNotNull(result);
        assertEquals(false, result.success);
        assertEquals("Customer cannot be null", result.errorMessages.get(0));
    }
}