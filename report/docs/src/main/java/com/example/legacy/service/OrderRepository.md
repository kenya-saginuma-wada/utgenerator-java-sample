# OrderRepository

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

| Item | Value |
|------|----|
| Package | `com.example.legacy.service` |
| File | `src/main/java/com/example/legacy/service/OrderRepository.java` |
| Lines | 5 |
| Methods | 2 |
| Fields | 0 |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`findById(String)`](#findbyid-string) | Public | 1 | 1 (Low) | - |
| [`save(Order)`](#save-order) | Public | 1 | 1 (Low) | - |

---

### findById(String)

**Summary**: Public / Parameters 1 / Calls 2

```java
findById(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String id |
| Output | Order |
| Preconditions | None |
| Postconditions | Returns Order. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
Order findById(String id);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 2 |

### save(Order)

**Summary**: Public / Parameters 1 / Calls 2

```java
save(Order)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | Order order |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
void save(Order order);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 2 |

