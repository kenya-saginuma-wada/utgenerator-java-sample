# OrderProcessingService

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 19 |
| Fields | 1 |
| Methods | 2 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 0 |
| Removed API Usage | 0 |
| Cycle Involvement | 0 |
| Brittleness Signals | 0 |

## Class Overview

**How to read**: Check package/file location and class traits first to understand context before method-level details.

**Type**: Class

| Item | Value |
|------|----|
| Package | `com.example.legacy` |
| File | `src/main/java/com/example/legacy/OrderProcessingService.java` |
| Lines | 19 |
| Methods | 2 |
| Fields | 1 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `supportedCurrencies` | `java.util.List<java.lang.String>` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`processOrder(String, double, String)`](#processorder-string-double-string) | Public | 10 | 1 (Low) | - |
| [`getSupportedCurrencies()`](#getsupportedcurrencies) | Public | 3 | 1 (Low) | - |

---

### processOrder(String, double, String)

**Summary**: Public / Parameters 3

```java
processOrder(String, double, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String orderId / double amount / String currency |
| Output | void |
| Preconditions | None |
| Postconditions | Main success path -> success |
| Error/Boundary | amount > 0 => boundary |
| Dependencies | PrintStream#println / Preconditions#checkArgument / Preconditions#checkArgument |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void processOrder(String orderId, double amount, String currency) {

    Preconditions.checkNotNull(orderId, "Order ID cannot be null");
    Preconditions.checkArgument(!orderId.isEmpty(), "Order ID cannot be empty");
    Preconditions.checkArgument(amount > 0, "Amount must be positive: %s", amount);
    Preconditions.checkNotNull(currency, "Currency cannot be null");
    Preconditions.checkArgument(supportedCurrencies.contains(currency), "Unsupported currency: %s", currency);
    System.out.println("Processing order " + orderId + " for " + amount + " " + currency);
}
```

| Metrics | Value |
|------------|----|
| Lines | 10 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 3 |
| Call Count | 0 |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| predicate | amount > 0 | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-2 | success | - | Main success path | success |
| path-1 | boundary | amount > 0 | Boundary condition amount > 0 | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | PrintStream | println | println(String) |
| 2 | List | contains | contains(Object) |
| 3 | Preconditions | checkArgument | checkArgument(boolean, Object) |
| 4 | Preconditions | checkArgument | checkArgument(boolean, String, Object) |
| 5 | String | isEmpty | isEmpty() |
| 6 | Preconditions | checkNotNull | checkNotNull(T, Object) |
| 7 | Preconditions | checkNotNull | checkNotNull(Object, Object) |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition amount > 0 / Condition: amount > 0 / Expected: boundary

### getSupportedCurrencies()

**Summary**: Public

```java
getSupportedCurrencies()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | List<String> |
| Preconditions | None |
| Postconditions | Returns List<String>. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public List<String> getSupportedCurrencies() {
    return supportedCurrencies;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

