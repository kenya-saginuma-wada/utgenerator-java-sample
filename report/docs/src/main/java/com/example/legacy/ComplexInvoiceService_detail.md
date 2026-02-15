# ComplexInvoiceService Detailed Design

## 1. Purpose and Responsibilities (Facts)
The `ComplexInvoiceService` class is responsible for calculating invoices based on customer data, a list of invoice items, a region code, an expedited flag, and a processing date. It performs various calculations including subtotal, tax, and discounts, and handles different region-specific logic.

## 2. External Class Specification
- Class Name: `ComplexInvoiceService`
- Package: `com.example.legacy`
- File Path: `src/main/java/com/example/legacy/ComplexInvoiceService.java`
- Class Type: Class
- Extends: None
- Implements: None
- Class Attributes:
  - nested_class: false
  - anonymous_class: false
  - has_nested_classes: true
  - enclosing_type: none
- Fields:
  - No fields

## 3. Method Specifications

### 3.1 calculateInvoice
#### 3.1.1 Inputs/Outputs
- **Inputs**:
  - `SimpleCustomerData customer`
  - `List<InvoiceItem> items`
  - `String regionCode`
  - `boolean isExpedited`
  - `LocalDate processingDate`
- **Outputs**:
  - `CalculationResult`

#### 3.1.2 Preconditions
- `customer != null`
- `items != null && !items.isEmpty()`
- `regionCode != null && !regionCode.isEmpty()`
- processingDate != null

#### 3.1.3 Postconditions
- Returns a `CalculationResult` object with calculated totals and success status.

#### 3.1.4 Normal Flow
1. Initialize `CalculationResult`, `subTotal`, `totalTax`, and `totalDiscount`.
2. Determine `customerTier` based on customer email and first name.
3. Iterate over `items` to calculate subtotal, tax, and discounts.
4. Apply region-specific logic using a switch-case on `regionCode`.
5. Log summary if the log entry is suspiciously large.

#### 3.1.5 Error/Boundary Handling
- If `customer` is null, set `result.success` to false and add "Customer cannot be null" to error messages.
- If `items` is null or empty, set `result.success` to false and add "Item list cannot be empty" to error messages.
- If `regionCode` is null or empty, set `result.success` to false and add "Invalid region code" to error messages.
- Continue loop if `item.getQuantity() <= 0` and add an error message.
- Break loop if `item.getUnitPrice() < 0`.

#### 3.1.6 Dependencies
- `java.util.List`
- `java.io.PrintStream`
- `java.math.BigDecimal`
- `com.example.legacy.ComplexInvoiceService.InvoiceItem`
- `com.example.legacy.SimpleCustomerData`

#### 3.1.7 Test Viewpoints
- Test with valid and invalid `customer` data.
- Test with empty and non-empty `items` list.
- Test with valid and invalid `regionCode`.
- Test with different `customerTier` values.
- Test switch-case logic for each `regionCode` value: "JP", "US_CA", "US_NY", "EU_DE", and default.

## 4. Cautions
- calculateInvoice has complexity 32 (>=15)

## 5. Recommendations (Optional)
- None

## 6. Open Questions (Insufficient Analysis)
- None