# ComplexInvoiceService

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 225 |
| Fields | 0 |
| Methods | 1 |
| High Complexity (>=15) | 1 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 0 |
| Removed API Usage | 0 |
| Cycle Involvement | 0 |
| Brittleness Signals | 0 |

## Class Overview

**How to read**: Check package/file location and class traits first to understand context before method-level details.

**Type**: Class

**Attributes**: Has inner classes

| Item | Value |
|------|----|
| Package | `com.example.legacy` |
| File | `src/main/java/com/example/legacy/ComplexInvoiceService.java` |
| Lines | 225 |
| Methods | 1 |
| Fields | 0 |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`calculateInvoice(SimpleCustomerData, List, String, boolean, LocalDate)`](#calculateinvoice-simplecustomerdata-list-string-boolean-localdate) | Public | 166 | 32 (Very High) | High Complexity |

---

### calculateInvoice(SimpleCustomerData, List, String, boolean, LocalDate)

**Summary**: Public / Parameters 5

```java
calculateInvoice(SimpleCustomerData, List, String, boolean, LocalDate)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | SimpleCustomerData customer / List<InvoiceItem> items / String regionCode / and 2 more |
| Output | CalculationResult |
| Preconditions | customer == null |
| Postconditions | Main success path -> success |
| Error/Boundary | processingDate.getDayOfWeek() == DayOfWeek.FRIDAY => boundary / processingDate.getMonthValue() == 12 => boundary |
| Dependencies | PrintStream#println / InvoiceItem#getItemId / InvoiceItem#getUnitPrice |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public CalculationResult calculateInvoice(SimpleCustomerData customer, List<InvoiceItem> items, String regionCode, boolean isExpedited, LocalDate processingDate) {
    CalculationResult result = new CalculationResult();
    BigDecimal subTotal = BigDecimal.ZERO;
    BigDecimal totalTax = BigDecimal.ZERO;
    BigDecimal totalDiscount = BigDecimal.ZERO;
    result.success = true;

    if (customer != null) {
        if (items != null && !items.isEmpty()) {
            if (regionCode != null && !regionCode.isEmpty()) {


                int customerTier = 0;
                if (customer.getEmail() != null && customer.getEmail().endsWith("@partner.com")) {
                    customerTier = 2;
                } else if (customer.getFirstName() != null && customer.getFirstName().startsWith("VIP")) {
                    customerTier = 1;
                }

                for (int i = 0; i < items.size(); i++) {
                    InvoiceItem item = items.get(i);

                    if (item.getQuantity() <= 0) {
                        result.errorMessages.add("Item " + item.getItemId() + " (Index: " + i + ") has invalid quantity.");

                        continue;
                    }
                    if (item.getUnitPrice() < 0) {
                        result.success = false;
                        result.errorMessages.add("Critical Error: Negative price for item " + item.getItemId());

                        break;
                    }
                    BigDecimal itemBasePrice = BigDecimal.valueOf(item.getUnitPrice()).multiply(BigDecimal.valueOf(item.getQuantity()));

                    BigDecimal itemDiscount = BigDecimal.ZERO;
                    if (item.isDiscountable()) {

                        if (customerTier == 2) {

                            itemDiscount = itemBasePrice.multiply(new BigDecimal("0.15"));
                        } else if (customerTier == 1) {
                            if (itemBasePrice.compareTo(new BigDecimal("1000")) > 0) {
                                itemDiscount = itemBasePrice.multiply(new BigDecimal("0.10"));
                            } else {
                                itemDiscount = itemBasePrice.multiply(new BigDecimal("0.05"));
                            }
                        } else {

                            if (processingDate.getDayOfWeek() == DayOfWeek.FRIDAY && "ELECTRONICS".equals(item.getCategory())) {

                                itemDiscount = itemBasePrice.multiply(new BigDecimal("0.02"));

                            } else if (item.getQuantity() >= 10) {

                                itemDiscount = itemBasePrice.multiply(new BigDecimal("0.03"));
                            }
                        }

                        if (processingDate.getMonthValue() == 12 && "GIFT".equals(item.getCategory())) {
                            itemDiscount = itemDiscount.add(itemBasePrice.multiply(new BigDecimal("0.05")));
                        }
                    }

                    if (itemDiscount.compareTo(itemBasePrice.multiply(new BigDecimal("0.5"))) > 0) {
                        itemDiscount = itemBasePrice.multiply(new BigDecimal("0.5"));
                    }
                    BigDecimal priceAfterDiscount = itemBasePrice.subtract(itemDiscount);
                    totalDiscount = totalDiscount.add(itemDiscount);

                    BigDecimal itemTax = BigDecimal.ZERO;
                    if (item.isTaxable()) {
                        double taxRate = 0.0;

                        switch(regionCode) {
                            case "JP":
                                taxRate = 0.10;

                                if ("FOOD".equals(item.getCategory())) {
                                    taxRate = 0.08;
                                }
                                break;
                            case "US_CA":
                                taxRate = 0.0725;
                                break;
                            case "US_NY":

                                taxRate = 0.088;
                                if (priceAfterDiscount.compareTo(new BigDecimal("110")) < 0 && "CLOTHING".equals(item.getCategory())) {

                                    taxRate = 0.0;
                                }
                                break;
                            case "EU_DE":
                                taxRate = 0.19;
                                break;
                            default:

                                taxRate = 0.05;
                        }
                        itemTax = priceAfterDiscount.multiply(BigDecimal.valueOf(taxRate));

                        if (regionCode.startsWith("JP")) {
                            itemTax = itemTax.setScale(0, RoundingMode.DOWN);
                        } else {
                            itemTax = itemTax.setScale(2, RoundingMode.HALF_UP);
                        }
                    }
                    totalTax = totalTax.add(itemTax);
                    subTotal = subTotal.add(priceAfterDiscount);
                }

                if (isExpedited) {
                    BigDecimal expeditedFee = new BigDecimal("500");

                    if (customerTier == 2) {
                        expeditedFee = BigDecimal.ZERO;
                    } else if (subTotal.compareTo(new BigDecimal("10000")) > 0) {
                        expeditedFee = expeditedFee.multiply(new BigDecimal("0.5"));
                    }
                    subTotal = subTotal.add(expeditedFee);
                }

                if (result.success) {
                    result.totalAmount = subTotal.add(totalTax);
                    result.taxAmount = totalTax;
                    result.discountAmount = totalDiscount;
                }
            } else {
                result.success = false;
                result.errorMessages.add("Invalid region code");
            }
        } else {
            result.success = false;
            result.errorMessages.add("Item list cannot be empty");
        }
    } else {
        result.success = false;
        result.errorMessages.add("Customer cannot be null");
    }

    if (result.totalAmount != null && customer != null) {

        String logSummary = "CALC_END: " + customer.getEmail() + " | " + result.totalAmount;
        if (logSummary.length() > 200) {

            System.out.println("Warning: Suspiciously large log entry");
        }
    }
    return result;
}
```

| Metrics | Value |
|------------|----|
| Lines | 166 |
| Complexity | 32 (Very High) |
| Nesting Depth | 9 |
| Parameters | 5 |
| Call Count | 0 |
| Structure | Has loops Has conditionals |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- High Complexity

> 🔴 **High Complexity**: Consider refactoring.

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | customer == null | msg: "Customer cannot be null" / success=false, addErrorMessage / 12:5 |
| fail-guard | items == null \|\| items.isEmpty() | msg: "Item list cannot be empty" / success=false, addErrorMessage / 13:9 |
| fail-guard | regionCode == null \|\| regionCode.isEmpty() | msg: "Invalid region code" / success=false, addErrorMessage / 14:13 |
| loop-guard-continue | item.getQuantity() <= 0 | continue / 27:21 |
| loop-guard-break | item.getUnitPrice() < 0 | break, success=false / 32:21 |
| switch | regionCode: "JP"/"US_CA"/"US_NY"/"EU_DE"/default | - |
| predicate | customer != null | - |
| predicate | customer.getEmail() != null | - |
| ... | ... | and 17 more |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | failure | customer == null | Validation failure: Customer cannot be null | failure |
| path-2 | failure | items == null \|\| items.isEmpty() | Validation failure: Item list cannot be empty | failure |
| path-3 | failure | regionCode == null \|\| regionCode.isEmpty() | Validation failure: Invalid region code | failure |
| path-4 | loop-continue | item.getQuantity() <= 0 | Loop guard continue | loop-continue |
| path-5 | loop-break | item.getUnitPrice() < 0 | Loop guard break | loop-break |
| path-13 | success | - | Main success path | success |
| path-6 | case-"JP" | regionCode == "JP" | Switch case regionCode="JP" | case-"JP" |
| path-7 | case-"US_CA" | regionCode == "US_CA" | Switch case regionCode="US_CA" | case-"US_CA" |
| ... | ... | ... | ... | and 5 more |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | List | get | get(int) |
| 2 | PrintStream | println | println(String) |
| 3 | InvoiceItem | getItemId | getItemId() |
| 4 | BigDecimal | multiply | multiply(BigDecimal) |
| 5 | BigDecimal | valueOf | valueOf(double) |
| 6 | InvoiceItem | getUnitPrice | getUnitPrice() |
| 7 | List | size | size() |
| 8 | List | add | add(E) |
| 9 | SimpleCustomerData | getEmail | getEmail() |
| 10 | BigDecimal | BigDecimal | BigDecimal(String) |
| ... | ... | ... | and 19 more |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Validation failure: Customer cannot be null / Condition: customer == null / Expected: failure
- Path: Validation failure: Item list cannot be empty / Condition: items == null || items.isEmpty() / Expected: failure
- Path: Validation failure: Invalid region code / Condition: regionCode == null || regionCode.isEmpty() / Expected: failure
- Path: Loop guard continue / Condition: item.getQuantity() <= 0 / Expected: loop-continue
- Path: Loop guard break / Condition: item.getUnitPrice() < 0 / Expected: loop-break
- Path: Main success path / Condition: - / Expected: success
- Path: Switch case regionCode="JP" / Condition: regionCode == "JP" / Expected: case-"JP"
- Path: Switch case regionCode="US_CA" / Condition: regionCode == "US_CA" / Expected: case-"US_CA"
- and 5 more
- Complexity-driven tests should cover branch combinations.

