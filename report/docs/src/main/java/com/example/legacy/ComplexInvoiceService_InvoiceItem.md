# InvoiceItem

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 43 |
| Fields | 6 |
| Methods | 7 |
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
| File | `src/main/java/com/example/legacy/ComplexInvoiceService.java` |
| Lines | 43 |
| Methods | 7 |
| Fields | 6 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `itemId` | `java.lang.String` | Private |
| `category` | `java.lang.String` | Private |
| `unitPrice` | `double` | Private |
| `quantity` | `int` | Private |
| `isTaxable` | `boolean` | Private |
| `isDiscountable` | `boolean` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`InvoiceItem(String, String, double, int, boolean, boolean)`](#invoiceitem-string-string-double-int-boolean-boolean) | Public | 9 | 1 (Low) | - |
| [`getItemId()`](#getitemid) | Public | 3 | 1 (Low) | - |
| [`getCategory()`](#getcategory) | Public | 3 | 1 (Low) | - |
| [`getUnitPrice()`](#getunitprice) | Public | 3 | 1 (Low) | - |
| [`getQuantity()`](#getquantity) | Public | 3 | 1 (Low) | - |
| [`isTaxable()`](#istaxable) | Public | 3 | 1 (Low) | - |
| [`isDiscountable()`](#isdiscountable) | Public | 3 | 1 (Low) | - |

---

### InvoiceItem(String, String, double, int, boolean, boolean)

**Summary**: Public / Parameters 6

```java
InvoiceItem(String, String, double, int, boolean, boolean)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String itemId / String category / double unitPrice / and 3 more |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public InvoiceItem(String itemId, String category, double unitPrice, int quantity, boolean isTaxable, boolean isDiscountable) {
    this.itemId = itemId;
    this.category = category;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
    this.isTaxable = isTaxable;
    this.isDiscountable = isDiscountable;
}
```

| Metrics | Value |
|------------|----|
| Lines | 9 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 6 |
| Call Count | 0 |

### getItemId()

**Summary**: Public / Calls 2

```java
getItemId()
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
public String getItemId() {
    return itemId;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 2 |

### getCategory()

**Summary**: Public / Calls 4

```java
getCategory()
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
public String getCategory() {
    return category;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 4 |

### getUnitPrice()

**Summary**: Public / Calls 2

```java
getUnitPrice()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | double |
| Preconditions | None |
| Postconditions | Returns double. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public double getUnitPrice() {
    return unitPrice;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 2 |

### getQuantity()

**Summary**: Public / Calls 3

```java
getQuantity()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | int |
| Preconditions | None |
| Postconditions | Returns int. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public int getQuantity() {
    return quantity;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 3 |

### isTaxable()

**Summary**: Public / Calls 1

```java
isTaxable()
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
public boolean isTaxable() {
    return isTaxable;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

### isDiscountable()

**Summary**: Public / Calls 1

```java
isDiscountable()
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
public boolean isDiscountable() {
    return isDiscountable;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

