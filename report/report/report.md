# UT Generation Report

- **Project**: my-project
- **Run ID**: `20260213_123502_A4D0`
- **Generated**: 2026-02-13 12:35:08

## Summary

| Metric | Value |
|--------|-------|
| Classes | 23 |
| Methods | 114 |
| Selected | 0 |
| Excluded | 0 |

## Analysis Hotspots

| Metric | Value |
|--------|-------|
| High Complexity Methods (>= 15) | 1 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 20 |
| Methods in Cycles | 0 |

## Analyzed Classes

| Class | Methods | LOC | Max Complexity | Avg Complexity |
|-------|---------|-----|----------------|----------------|
| [`com.example.legacy.ComplexInvoiceService`](src/main/java/com/example/legacy/ComplexInvoiceService.html) | 2 | 225 | 32 | 16.5 |
| [`com.example.legacy.PaymentService`](src/main/java/com/example/legacy/PaymentService.html) | 6 | 300 | 7 | 3.0 |
| [`com.example.legacy.CustomerService`](src/main/java/com/example/legacy/CustomerService.html) | 7 | 147 | 5 | 2.6 |
| [`com.example.legacy.service.OrderService`](src/main/java/com/example/legacy/service/OrderService.html) | 4 | 59 | 3 | 2.0 |
| [`com.example.legacy.MessageService`](src/main/java/com/example/legacy/MessageService.html) | 2 | 13 | 3 | 2.0 |
| [`com.example.legacy.util.StringUtil`](src/main/java/com/example/legacy/util/StringUtil.html) | 4 | 23 | 3 | 1.8 |
| [`com.example.legacy.SimpleCustomerData`](src/main/java/com/example/legacy/SimpleCustomerData.html) | 15 | 73 | 3 | 1.1 |
| [`com.example.legacy.DynamicTestPatterns`](src/main/java/com/example/legacy/DynamicTestPatterns.html) | 9 | 81 | 2 | 1.1 |

## Risky Methods

| Class | Method | Complexity | LOC |
|-------|--------|------------|-----|
| `com.example.legacy.ComplexInvoiceService` | `calculateInvoice` | 32 | 166 |
| `com.example.legacy.PaymentService` | `processPayment` | 7 | 45 |
| `com.example.legacy.PaymentService` | `refundPayment` | 6 | 30 |
| `com.example.legacy.CustomerService` | `getActiveCustomers` | 5 | 15 |
| `com.example.legacy.CustomerService` | `findCustomerById` | 4 | 13 |
| `com.example.legacy.service.OrderService` | `processOrder` | 3 | 19 |
| `com.example.legacy.service.OrderService` | `cancelOrder` | 3 | 16 |
| `com.example.legacy.SimpleCustomerData` | `equals` | 3 | 11 |
| `com.example.legacy.MessageService` | `formatMessage` | 3 | 10 |
| `com.example.legacy.CustomerService` | `addCustomer` | 3 | 9 |
| `com.example.legacy.CustomerService` | `addCustomer` | 3 | 9 |
| `com.example.legacy.util.StringUtil` | `truncate` | 3 | 9 |

## Recommendations

- Prioritize focused tests for `com.example.legacy.ComplexInvoiceService#calculateInvoice` (complexity=32).
- Review `com.example.legacy.ComplexInvoiceService` for decomposition (methods=2, max complexity=32).
- Maintain regression tests around payment, billing, and customer-facing business rules.

