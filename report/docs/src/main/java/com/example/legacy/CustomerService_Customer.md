# Customer

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 56 |
| Fields | 5 |
| Methods | 11 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 2 |
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
| File | `src/main/java/com/example/legacy/CustomerService.java` |
| Lines | 56 |
| Methods | 11 |
| Fields | 5 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `id` | `java.lang.String` | Private |
| `name` | `java.lang.String` | Private |
| `active` | `boolean` | Private |
| `balance` | `double` | Private |
| `premium` | `boolean` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`Customer(String, String)`](#customer-string-string) | Public | 7 | 1 (Low) | - |
| [`getId()`](#getid) | Public | 3 | 1 (Low) | Duplicate |
| [`setId(String)`](#setid-string) | Public | 3 | 1 (Low) | Duplicate |
| [`getName()`](#getname) | Public | 3 | 1 (Low) | - |
| [`setName(String)`](#setname-string) | Public | 3 | 1 (Low) | - |
| [`isActive()`](#isactive) | Public | 3 | 1 (Low) | - |
| [`setActive(boolean)`](#setactive-boolean) | Public | 3 | 1 (Low) | - |
| [`getBalance()`](#getbalance) | Public | 3 | 1 (Low) | - |
| [`setBalance(double)`](#setbalance-double) | Public | 3 | 1 (Low) | - |
| [`isPremium()`](#ispremium) | Public | 3 | 1 (Low) | - |
| [`setPremium(boolean)`](#setpremium-boolean) | Public | 3 | 1 (Low) | - |

---

### Customer(String, String)

**Summary**: Public / Parameters 2

```java
Customer(String, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String id / String name |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Customer(String id, String name) {
    this.id = id;
    this.name = name;
    this.active = true;
    this.balance = 0.0;
    this.premium = false;
}
```

| Metrics | Value |
|------------|----|
| Lines | 7 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 2 |
| Call Count | 0 |

### getId()

**Summary**: Public / Calls 3

```java
getId()
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
public String getId() {
    return id;
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

- Duplicate code (group: b33091cee4b70779a00ed930b77bf127a5f8119ff98c2db3e8eaa8e7bec6708f)

> ⚠️ **Warning**: Duplicate code detected (group: b33091cee4b70779a00ed930b77bf127a5f8119ff98c2db3e8eaa8e7bec6708f).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### setId(String)

**Summary**: Public / Parameters 1

```java
setId(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String id |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setId(String id) {
    this.id = id;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: 8ece8f2d8f34c6bba310327ceeae294d059a5b7817bc618f3a0ae1287a3e407f)

> ⚠️ **Warning**: Duplicate code detected (group: 8ece8f2d8f34c6bba310327ceeae294d059a5b7817bc618f3a0ae1287a3e407f).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### getName()

**Summary**: Public

```java
getName()
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
public String getName() {
    return name;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

### setName(String)

**Summary**: Public / Parameters 1

```java
setName(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String name |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setName(String name) {
    this.name = name;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### isActive()

**Summary**: Public / Calls 1

```java
isActive()
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
public boolean isActive() {
    return active;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

### setActive(boolean)

**Summary**: Public / Parameters 1

```java
setActive(boolean)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | boolean active |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setActive(boolean active) {
    this.active = active;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### getBalance()

**Summary**: Public / Calls 1

```java
getBalance()
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
public double getBalance() {
    return balance;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

### setBalance(double)

**Summary**: Public / Parameters 1

```java
setBalance(double)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | double balance |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setBalance(double balance) {
    this.balance = balance;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### isPremium()

**Summary**: Public / Calls 1

```java
isPremium()
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
public boolean isPremium() {
    return premium;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 1 |

### setPremium(boolean)

**Summary**: Public / Parameters 1

```java
setPremium(boolean)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | boolean premium |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setPremium(boolean premium) {
    this.premium = premium;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

