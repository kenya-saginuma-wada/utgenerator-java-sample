# ICustomerRepository

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Interface |
| Lines | 33 |
| Fields | 0 |
| Methods | 4 |
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
| Package | `com.example.legacy` |
| File | `src/main/java/com/example/legacy/ICustomerRepository.java` |
| Lines | 33 |
| Methods | 4 |
| Fields | 0 |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`findById(String)`](#findbyid-string) | Public | 1 | 1 (Low) | - |
| [`findByName(String)`](#findbyname-string) | Public | 1 | 1 (Low) | - |
| [`save(SimpleCustomerData)`](#save-simplecustomerdata) | Public | 1 | 1 (Low) | - |
| [`delete(String)`](#delete-string) | Public | 1 | 1 (Low) | - |

---

### findById(String)

**Summary**: Public / Parameters 1

```java
findById(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String id |
| Output | Optional<SimpleCustomerData> |
| Preconditions | None |
| Postconditions | Returns Optional<SimpleCustomerData>. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
Optional<SimpleCustomerData> findById(String id);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### findByName(String)

**Summary**: Public / Parameters 1

```java
findByName(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String namePattern |
| Output | List<SimpleCustomerData> |
| Preconditions | None |
| Postconditions | Returns List<SimpleCustomerData>. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
List<SimpleCustomerData> findByName(String namePattern);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### save(SimpleCustomerData)

**Summary**: Public / Parameters 1

```java
save(SimpleCustomerData)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | SimpleCustomerData customer |
| Output | SimpleCustomerData |
| Preconditions | None |
| Postconditions | Returns SimpleCustomerData. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
SimpleCustomerData save(SimpleCustomerData customer);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### delete(String)

**Summary**: Public / Parameters 1

```java
delete(String)
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
void delete(String id);
```

| Metrics | Value |
|------------|----|
| Lines | 1 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

