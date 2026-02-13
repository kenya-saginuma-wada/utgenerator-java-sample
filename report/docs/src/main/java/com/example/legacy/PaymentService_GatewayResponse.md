# GatewayResponse

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 31 |
| Fields | 3 |
| Methods | 6 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 1 |
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
| Lines | 31 |
| Methods | 6 |
| Fields | 3 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `success` | `boolean` | Private |
| `transactionId` | `java.lang.String` | Private |
| `errorMessage` | `java.lang.String` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`GatewayResponse(boolean, String, String)`](#gatewayresponse-boolean-string-string) | Private | 5 | 1 (Low) | - |
| [`success(String)`](#success-string) | Public | 3 | 1 (Low) | - |
| [`failure(String)`](#failure-string) | Public | 3 | 1 (Low) | - |
| [`isSuccess()`](#issuccess) | Public | 3 | 1 (Low) | - |
| [`getTransactionId()`](#gettransactionid) | Public | 3 | 1 (Low) | Duplicate |
| [`getErrorMessage()`](#geterrormessage) | Public | 3 | 1 (Low) | - |

---

### GatewayResponse(boolean, String, String)

**Summary**: Private / Parameters 3 / Calls 2

```java
GatewayResponse(boolean, String, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | boolean success / String transactionId / String errorMessage |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
private GatewayResponse(boolean success, String transactionId, String errorMessage) {
    this.success = success;
    this.transactionId = transactionId;
    this.errorMessage = errorMessage;
}
```

| Metrics | Value |
|------------|----|
| Lines | 5 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 3 |
| Call Count | 2 |

### success(String)

**Summary**: Public / static / Parameters 1

```java
success(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String transactionId |
| Output | GatewayResponse |
| Preconditions | None |
| Postconditions | Returns GatewayResponse. |
| Error/Boundary | None |
| Dependencies | GatewayResponse#GatewayResponse |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public static GatewayResponse success(String transactionId) {
    return new GatewayResponse(true, transactionId, null);
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | GatewayResponse | GatewayResponse | GatewayResponse(boolean, String, String) |

### failure(String)

**Summary**: Public / static / Parameters 1

```java
failure(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String errorMessage |
| Output | GatewayResponse |
| Preconditions | None |
| Postconditions | Returns GatewayResponse. |
| Error/Boundary | None |
| Dependencies | GatewayResponse#GatewayResponse |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public static GatewayResponse failure(String errorMessage) {
    return new GatewayResponse(false, null, errorMessage);
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | GatewayResponse | GatewayResponse | GatewayResponse(boolean, String, String) |

### isSuccess()

**Summary**: Public / Calls 2

```java
isSuccess()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | boolean |
| Preconditions | None |
| Postconditions | Returns boolean. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public boolean isSuccess() {
    return success;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 2 |

### getTransactionId()

**Summary**: Public / Calls 3

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
| Call Count | 3 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: 46e57ab3043bd9ae82aaf6fcf0d3d4279ff2aec00cc71142195bec01a1709517)

> ⚠️ **Warning**: Duplicate code detected (group: 46e57ab3043bd9ae82aaf6fcf0d3d4279ff2aec00cc71142195bec01a1709517).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### getErrorMessage()

**Summary**: Public / Calls 2

```java
getErrorMessage()
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
public String getErrorMessage() {
    return errorMessage;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 2 |

