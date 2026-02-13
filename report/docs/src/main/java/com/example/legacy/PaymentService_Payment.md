# Payment

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 52 |
| Fields | 7 |
| Methods | 9 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 3 |
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
| Lines | 52 |
| Methods | 9 |
| Fields | 7 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `transactionId` | `java.lang.String` | Private |
| `orderId` | `java.lang.String` | Private |
| `customerId` | `java.lang.String` | Private |
| `amount` | `java.math.BigDecimal` | Private |
| `paymentMethod` | `java.lang.String` | Private |
| `status` | `java.lang.String` | Private |
| `createdAt` | `java.time.LocalDateTime` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`Payment(String, String, String, BigDecimal, String, String, LocalDateTime)`](#payment-string-string-string-bigdecimal-string-string-localdatetime) | Public | 10 | 1 (Low) | - |
| [`getTransactionId()`](#gettransactionid) | Public | 3 | 1 (Low) | Duplicate |
| [`getOrderId()`](#getorderid) | Public | 3 | 1 (Low) | - |
| [`getCustomerId()`](#getcustomerid) | Public | 3 | 1 (Low) | - |
| [`getAmount()`](#getamount) | Public | 3 | 1 (Low) | - |
| [`getPaymentMethod()`](#getpaymentmethod) | Public | 3 | 1 (Low) | - |
| [`getStatus()`](#getstatus) | Public | 3 | 1 (Low) | Duplicate |
| [`setStatus(String)`](#setstatus-string) | Public | 3 | 1 (Low) | Duplicate |
| [`getCreatedAt()`](#getcreatedat) | Public | 3 | 1 (Low) | - |

---

### Payment(String, String, String, BigDecimal, String, String, LocalDateTime)

**Summary**: Public / Parameters 7 / Calls 1

```java
Payment(String, String, String, BigDecimal, String, String, LocalDateTime)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String transactionId / String orderId / String customerId / and 4 more |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Payment(String transactionId, String orderId, String customerId, BigDecimal amount, String paymentMethod, String status, LocalDateTime createdAt) {
    this.transactionId = transactionId;
    this.orderId = orderId;
    this.customerId = customerId;
    this.amount = amount;
    this.paymentMethod = paymentMethod;
    this.status = status;
    this.createdAt = createdAt;
}
```

| Metrics | Value |
|------------|----|
| Lines | 10 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 7 |
| Call Count | 1 |

### getTransactionId()

**Summary**: Public

```java
getTransactionId()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | String |
| Preconditions | None |
| Postconditions | Returns String. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public String getTransactionId() {
    return transactionId;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: 46e57ab3043bd9ae82aaf6fcf0d3d4279ff2aec00cc71142195bec01a1709517)

> ⚠️ **Warning**: Duplicate code detected (group: 46e57ab3043bd9ae82aaf6fcf0d3d4279ff2aec00cc71142195bec01a1709517).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### getOrderId()

**Summary**: Public / Calls 1

```java
getOrderId()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | String |
| Preconditions | None |
| Postconditions | Returns String. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public String getOrderId() {
    return orderId;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

### getCustomerId()

**Summary**: Public / Calls 1

```java
getCustomerId()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | String |
| Preconditions | None |
| Postconditions | Returns String. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public String getCustomerId() {
    return customerId;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

### getAmount()

**Summary**: Public / Calls 2

```java
getAmount()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | BigDecimal |
| Preconditions | None |
| Postconditions | Returns BigDecimal. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public BigDecimal getAmount() {
    return amount;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 2 |

### getPaymentMethod()

**Summary**: Public

```java
getPaymentMethod()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | String |
| Preconditions | None |
| Postconditions | Returns String. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public String getPaymentMethod() {
    return paymentMethod;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

### getStatus()

**Summary**: Public / Calls 1

```java
getStatus()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | String |
| Preconditions | None |
| Postconditions | Returns String. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public String getStatus() {
    return status;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: e3e8b9d1f05c55c8339395ef7cc14dbdfc825a31a741faa8826fde65d8ff6e17)

> ⚠️ **Warning**: Duplicate code detected (group: e3e8b9d1f05c55c8339395ef7cc14dbdfc825a31a741faa8826fde65d8ff6e17).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### setStatus(String)

**Summary**: Public / Parameters 1 / Calls 1

```java
setStatus(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String status |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setStatus(String status) {
    this.status = status;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 1 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: 0fe515c1dd3f565aa160cb7eb477a843386a838d148661f0f9c781a02c1aa774)

> ⚠️ **Warning**: Duplicate code detected (group: 0fe515c1dd3f565aa160cb7eb477a843386a838d148661f0f9c781a02c1aa774).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### getCreatedAt()

**Summary**: Public

```java
getCreatedAt()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | LocalDateTime |
| Preconditions | None |
| Postconditions | Returns LocalDateTime. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public LocalDateTime getCreatedAt() {
    return createdAt;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

