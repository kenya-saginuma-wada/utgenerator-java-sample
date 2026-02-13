# StringUtil

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 23 |
| Fields | 0 |
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

| Item | Value |
|------|----|
| Package | `com.example.legacy.util` |
| File | `src/main/java/com/example/legacy/util/StringUtil.java` |
| Lines | 23 |
| Methods | 3 |
| Fields | 0 |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`isEmpty(String)`](#isempty-string) | Public | 3 | 1 (Low) | - |
| [`toUpperCase(String)`](#touppercase-string) | Public | 6 | 2 (Low) | - |
| [`truncate(String, int)`](#truncate-string-int) | Public | 9 | 3 (Low) | - |

---

### isEmpty(String)

**Summary**: Public / static / Parameters 1 / Calls 2

```java
isEmpty(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String str |
| Output | boolean |
| Preconditions | None |
| Postconditions | Main success path -> success |
| Error/Boundary | str == null => boundary |
| Dependencies | String#trim / String#isEmpty |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public static boolean isEmpty(String str) {
    return str == null || str.trim().isEmpty();
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 2 |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| predicate | str == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-2 | success | - | Main success path | success |
| path-1 | boundary | str == null | Boundary condition str == null | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | String | trim | trim() |
| 2 | String | isEmpty | isEmpty() |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition str == null / Condition: str == null / Expected: boundary

### toUpperCase(String)

**Summary**: Public / static / Parameters 1 / Calls 1

```java
toUpperCase(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String str |
| Output | String |
| Preconditions | str == null |
| Postconditions | Main success path -> success |
| Error/Boundary | str == null => early-return |
| Dependencies | String#toUpperCase |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public static String toUpperCase(String str) {
    if (str == null) {
        return null;
    }
    return str.toUpperCase();
}
```

| Metrics | Value |
|------------|----|
| Lines | 6 |
| Complexity | 2 (Low) |
| Nesting Depth | 1 |
| Parameters | 1 |
| Call Count | 1 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | str == null | 2:5 |
| predicate | str == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | str == null | Early return path | early-return |
| path-2 | success | - | Main success path | success |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | String | toUpperCase | toUpperCase() |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: str == null / Expected: early-return
- Path: Main success path / Condition: - / Expected: success

### truncate(String, int)

**Summary**: Public / static / Parameters 2 / Calls 1

```java
truncate(String, int)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String str / int length |
| Output | String |
| Preconditions | str == null |
| Postconditions | Main success path -> success |
| Error/Boundary | str == null => early-return / str.length() <= length => boundary |
| Dependencies | String#length / String#substring |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public static String truncate(String str, int length) {
    if (str == null) {
        return null;
    }
    if (str.length() <= length) {
        return str;
    }
    return str.substring(0, length);
}
```

| Metrics | Value |
|------------|----|
| Lines | 9 |
| Complexity | 3 (Low) |
| Nesting Depth | 1 |
| Parameters | 2 |
| Call Count | 1 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | str == null | 2:5 |
| predicate | str == null | - |
| predicate | str.length() <= length | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | str == null | Early return path | early-return |
| path-3 | success | - | Main success path | success |
| path-2 | boundary | str.length() <= length | Boundary condition str.length() <= length | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | String | length | length() |
| 2 | String | substring | substring(int, int) |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: str == null / Expected: early-return
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition str.length() <= length / Condition: str.length() <= length / Expected: boundary

