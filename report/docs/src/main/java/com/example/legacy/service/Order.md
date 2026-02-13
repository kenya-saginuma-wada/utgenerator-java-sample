# Order

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 28 |
| Fields | 2 |
| Methods | 6 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 5 |
| Removed API Usage | 0 |
| Cycle Involvement | 0 |
| Brittleness Signals | 0 |

## Class Overview

**How to read**: Check package/file location and class traits first to understand context before method-level details.

**Type**: Class

| Item | Value |
|------|----|
| Package | `com.example.legacy.service` |
| File | `src/main/java/com/example/legacy/service/Order.java` |
| Lines | 28 |
| Methods | 6 |
| Fields | 2 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `id` | `java.lang.String` | Private |
| `status` | `java.lang.String` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`Order()`](#order) | Public | 2 | 1 (Low) | Duplicate |
| [`Order(String, String)`](#order-string-string) | Public | 4 | 1 (Low) | - |
| [`getId()`](#getid) | Public | 3 | 1 (Low) | Duplicate |
| [`setId(String)`](#setid-string) | Public | 3 | 1 (Low) | Duplicate |
| [`getStatus()`](#getstatus) | Public | 3 | 1 (Low) | Duplicate |
| [`setStatus(String)`](#setstatus-string) | Public | 3 | 1 (Low) | Duplicate |

---

### Order()

**Summary**: Public

```java
Order()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Order() {
}
```

| Metrics | Value |
|------------|----|
| Lines | 2 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: 44136fa355b3678a1146ad16f7e8649e94fb4fc21fe77e8310c060f61caaff8a)

> ⚠️ **Warning**: Duplicate code detected (group: 44136fa355b3678a1146ad16f7e8649e94fb4fc21fe77e8310c060f61caaff8a).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### Order(String, String)

**Summary**: Public / Parameters 2

```java
Order(String, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String id / String status |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Order(String id, String status) {
    this.id = id;
    this.status = status;
}
```

| Metrics | Value |
|------------|----|
| Lines | 4 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 2 |
| Call Count | 0 |

### getId()

**Summary**: Public

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
| Call Count | 0 |

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

### getStatus()

**Summary**: Public

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
| Call Count | 0 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: e3e8b9d1f05c55c8339395ef7cc14dbdfc825a31a741faa8826fde65d8ff6e17)

> ⚠️ **Warning**: Duplicate code detected (group: e3e8b9d1f05c55c8339395ef7cc14dbdfc825a31a741faa8826fde65d8ff6e17).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

### setStatus(String)

**Summary**: Public / Parameters 1 / Calls 2

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
| Call Count | 2 |

**Quality Signals**:
**How to read**: Use these signals to identify methods that should be refactored or tested more aggressively.

- Duplicate code (group: 0fe515c1dd3f565aa160cb7eb477a843386a838d148661f0f9c781a02c1aa774)

> ⚠️ **Warning**: Duplicate code detected (group: 0fe515c1dd3f565aa160cb7eb477a843386a838d148661f0f9c781a02c1aa774).

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Validate behavior parity with duplicate counterparts.

