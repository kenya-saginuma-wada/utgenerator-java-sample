# NotificationService

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Interface |
| Lines | 5 |
| Fields | 0 |
| Methods | 2 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 0 |
| Removed API Usage | 0 |
| Cycle Involvement | 0 |
| Brittleness Signals | 0 |

## Class Overview

**How to read**: Check package/file location and class traits first to understand context before method-level details.

**Type**: Interface

**Attributes**: Nested

| Item | Value |
|------|----|
| Package | `com.example.legacy` |
| File | `src/main/java/com/example/legacy/PaymentService.java` |
| Lines | 5 |
| Methods | 2 |
| Fields | 0 |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`sendPaymentConfirmation(String, String, BigDecimal)`](#sendpaymentconfirmation-string-string-bigdecimal) | Package-private | 1 | 1 (Low) | - |
| [`sendRefundConfirmation(String, String, BigDecimal)`](#sendrefundconfirmation-string-string-bigdecimal) | Package-private | 1 | 1 (Low) | - |

---

### sendPaymentConfirmation(String, String, BigDecimal)

**Summary**: Package-private / Parameters 3 / Calls 1

```java
sendPaymentConfirmation(String, String, BigDecimal)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String customerId / String orderId / BigDecimal amount |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
void sendPaymentConfirmation(String customerId, String orderId, BigDecimal amount);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 3 |
| Call Count | 1 |

### sendRefundConfirmation(String, String, BigDecimal)

**Summary**: Package-private / Parameters 3 / Calls 1

```java
sendRefundConfirmation(String, String, BigDecimal)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String customerId / String orderId / BigDecimal amount |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
void sendRefundConfirmation(String customerId, String orderId, BigDecimal amount);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 3 |
| Call Count | 1 |

