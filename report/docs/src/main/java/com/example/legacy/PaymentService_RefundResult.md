# RefundResult

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 22 |
| Fields | 4 |
| Methods | 3 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 0 |
| Removed API Usage | 0 |
| Cycle Involvement | 0 |
| Brittleness Signals | 0 |

## Class Overview

**How to read**: Check package/file location and class traits first to understand context before method-level details.

**Type**: Class

**Attributes**: Nested

| Item | Value |
|------|----|
| Package | `com.example.legacy` |
| File | `src/main/java/com/example/legacy/PaymentService.java` |
| Lines | 22 |
| Methods | 3 |
| Fields | 4 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `success` | `boolean` | Public |
| `refundTransactionId` | `java.lang.String` | Public |
| `refundAmount` | `java.math.BigDecimal` | Public |
| `errorMessage` | `java.lang.String` | Public |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`RefundResult(boolean, String, BigDecimal, String)`](#refundresult-boolean-string-bigdecimal-string) | Private | 7 | 1 (Low) | - |
| [`success(String, BigDecimal)`](#success-string-bigdecimal) | Public | 3 | 1 (Low) | - |
| [`failure(String)`](#failure-string) | Public | 3 | 1 (Low) | - |

---

### RefundResult(boolean, String, BigDecimal, String)

**Summary**: Private / Parameters 4 / Calls 2

```java
RefundResult(boolean, String, BigDecimal, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | boolean success / String refundTransactionId / BigDecimal refundAmount / and 1 more |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
private RefundResult(boolean success, String refundTransactionId, BigDecimal refundAmount, String errorMessage) {
    this.success = success;
    this.refundTransactionId = refundTransactionId;
    this.refundAmount = refundAmount;
    this.errorMessage = errorMessage;
}
```

| Metrics | Value |
|------------|----|
| Lines | 7 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 4 |
| Call Count | 2 |

### success(String, BigDecimal)

**Summary**: Public / static / Parameters 2 / Calls 1

```java
success(String, BigDecimal)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String refundTransactionId / BigDecimal refundAmount |
| Output | RefundResult |
| Preconditions | None |
| Postconditions | Returns RefundResult. |
| Error/Boundary | None |
| Dependencies | RefundResult#RefundResult |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public static RefundResult success(String refundTransactionId, BigDecimal refundAmount) {
    return new RefundResult(true, refundTransactionId, refundAmount, null);
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 2 |
| Call Count | 1 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | RefundResult | RefundResult | RefundResult(boolean, String, BigDecimal, String) |

### failure(String)

**Summary**: Public / static / Parameters 1 / Calls 4

```java
failure(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String errorMessage |
| Output | RefundResult |
| Preconditions | None |
| Postconditions | Returns RefundResult. |
| Error/Boundary | None |
| Dependencies | RefundResult#RefundResult |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public static RefundResult failure(String errorMessage) {
    return new RefundResult(false, null, null, errorMessage);
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 4 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | RefundResult | RefundResult | RefundResult(boolean, String, BigDecimal, String) |

