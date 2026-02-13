# SimpleCustomerData

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 73 |
| Fields | 4 |
| Methods | 13 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 1 |
| Removed API Usage | 0 |
| Cycle Involvement | 0 |
| Brittleness Signals | 0 |

## Class Overview

**How to read**: Check package/file location and class traits first to understand context before method-level details.

**Type**: Class

| Item | Value |
|------|----|
| Package | `com.example.legacy` |
| File | `src/main/java/com/example/legacy/SimpleCustomerData.java` |
| Lines | 73 |
| Methods | 13 |
| Fields | 4 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `firstName` | `java.lang.String` | Private |
| `lastName` | `java.lang.String` | Private |
| `email` | `java.lang.String` | Private |
| `paramDate` | `java.time.LocalDate` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`SimpleCustomerData()`](#simplecustomerdata) | Public | 2 | 1 (Low) | Duplicate |
| [`SimpleCustomerData(String, String, String)`](#simplecustomerdata-string-string-string) | Public | 5 | 1 (Low) | - |
| [`getFirstName()`](#getfirstname) | Public | 3 | 1 (Low) | - |
| [`setFirstName(String)`](#setfirstname-string) | Public | 3 | 1 (Low) | - |
| [`getLastName()`](#getlastname) | Public | 3 | 1 (Low) | - |
| [`setLastName(String)`](#setlastname-string) | Public | 3 | 1 (Low) | - |
| [`getEmail()`](#getemail) | Public | 3 | 1 (Low) | - |
| [`setEmail(String)`](#setemail-string) | Public | 3 | 1 (Low) | - |
| [`getParamDate()`](#getparamdate) | Public | 3 | 1 (Low) | - |
| [`setParamDate(LocalDate)`](#setparamdate-localdate) | Public | 3 | 1 (Low) | - |
| [`equals(Object)`](#equals-object) | Public | 11 | 3 (Low) | - |
| [`hashCode()`](#hashcode) | Public | 4 | 1 (Low) | - |
| [`toString()`](#tostring) | Public | 8 | 1 (Low) | - |

---

### SimpleCustomerData()

**Summary**: Public

```java
SimpleCustomerData()
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
public SimpleCustomerData() {
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

### SimpleCustomerData(String, String, String)

**Summary**: Public / Parameters 3

```java
SimpleCustomerData(String, String, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String firstName / String lastName / String email |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public SimpleCustomerData(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
}
```

| Metrics | Value |
|------------|----|
| Lines | 5 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 3 |
| Call Count | 0 |

### getFirstName()

**Summary**: Public / Calls 2

```java
getFirstName()
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
public String getFirstName() {
    return firstName;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 2 |

### setFirstName(String)

**Summary**: Public / Parameters 1

```java
setFirstName(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String firstName |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### getLastName()

**Summary**: Public

```java
getLastName()
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
public String getLastName() {
    return lastName;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

### setLastName(String)

**Summary**: Public / Parameters 1

```java
setLastName(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String lastName |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setLastName(String lastName) {
    this.lastName = lastName;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### getEmail()

**Summary**: Public / Calls 3

```java
getEmail()
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
public String getEmail() {
    return email;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 3 |

### setEmail(String)

**Summary**: Public / Parameters 1

```java
setEmail(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String email |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setEmail(String email) {
    this.email = email;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### getParamDate()

**Summary**: Public

```java
getParamDate()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | LocalDate |
| Preconditions | None |
| Postconditions | Returns LocalDate. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public LocalDate getParamDate() {
    return paramDate;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

### setParamDate(LocalDate)

**Summary**: Public / Parameters 1

```java
setParamDate(LocalDate)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | LocalDate paramDate |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void setParamDate(LocalDate paramDate) {
    this.paramDate = paramDate;
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

### equals(Object)

**Summary**: Public / Parameters 1

```java
equals(Object)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | Object o |
| Output | @Override public boolean |
| Preconditions | o == null \|\| getClass() != o.getClass() |
| Postconditions | Main success path -> success |
| Error/Boundary | o == null \|\| getClass() != o.getClass() => early-return / getClass() != o.getClass() => boundary / o == null => boundary / and 1 more |
| Dependencies | Objects#equals / Object#getClass |

**Annotations**: `@Override` 

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    SimpleCustomerData that = (SimpleCustomerData) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email);
}
```

| Metrics | Value |
|------------|----|
| Lines | 11 |
| Complexity | 3 (Low) |
| Nesting Depth | 1 |
| Parameters | 1 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | o == null \|\| getClass() != o.getClass() | 5:5 |
| predicate | getClass() != o.getClass() | - |
| predicate | o == null | - |
| predicate | this == o | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | o == null \|\| getClass() != o.getClass() | Early return path | early-return |
| path-5 | success | - | Main success path | success |
| path-2 | boundary | getClass() != o.getClass() | Boundary condition getClass() != o.getClass() | boundary |
| path-3 | boundary | o == null | Boundary condition o == null | boundary |
| path-4 | boundary | this == o | Boundary condition this == o | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Object | getClass | getClass() |
| 2 | Objects | equals | equals(Object, Object) |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: o == null || getClass() != o.getClass() / Expected: early-return
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition getClass() != o.getClass() / Condition: getClass() != o.getClass() / Expected: boundary
- Path: Boundary condition o == null / Condition: o == null / Expected: boundary
- Path: Boundary condition this == o / Condition: this == o / Expected: boundary

### hashCode()

**Summary**: Public

```java
hashCode()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | @Override public int |
| Preconditions | None |
| Postconditions | Returns @Override public int. |
| Error/Boundary | None |
| Dependencies | Objects#hash / Objects#hash |

**Annotations**: `@Override` 

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
@Override
public int hashCode() {
    return Objects.hash(firstName, lastName, email);
}
```

| Metrics | Value |
|------------|----|
| Lines | 4 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Objects | hash | hash(java.lang.Object...) |
| 2 | Objects | hash | hash(Object[]) |

### toString()

**Summary**: Public

```java
toString()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | @Override public String |
| Preconditions | None |
| Postconditions | Returns @Override public String. |
| Error/Boundary | None |
| Dependencies | None |

**Annotations**: `@Override` 

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
@Override
public String toString() {
    return "SimpleCustomerData{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + '}';
}
```

| Metrics | Value |
|------------|----|
| Lines | 8 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

