# MessageService

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 13 |
| Fields | 0 |
| Methods | 1 |
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
| File | `src/main/java/com/example/legacy/MessageService.java` |
| Lines | 13 |
| Methods | 1 |
| Fields | 0 |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`formatMessage(String, String)`](#formatmessage-string-string) | Public | 10 | 3 (Low) | - |

---

### formatMessage(String, String)

**Summary**: Public / Parameters 2

```java
formatMessage(String, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String prefix / String body |
| Output | String |
| Preconditions | StringUtil.isEmpty(body) |
| Postconditions | Main success path -> success |
| Error/Boundary | StringUtil.isEmpty(body) => early-return |
| Dependencies | StringUtil#toUpperCase / StringUtil#isEmpty / StringUtil#truncate |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public String formatMessage(String prefix, String body) {
    if (StringUtil.isEmpty(body)) {
        return "";
    }
    String cleanPrefix = StringUtil.isEmpty(prefix) ? "MSG" : StringUtil.toUpperCase(prefix);
    String truncatedBody = StringUtil.truncate(body, 100);
    return cleanPrefix + ": " + truncatedBody;
}
```

| Metrics | Value |
|------------|----|
| Lines | 10 |
| Complexity | 3 (Low) |
| Nesting Depth | 1 |
| Parameters | 2 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | StringUtil.isEmpty(body) | 2:5 |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | StringUtil.isEmpty(body) | Early return path | early-return |
| path-2 | success | - | Main success path | success |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | StringUtil | toUpperCase | toUpperCase(String) |
| 2 | StringUtil | isEmpty | isEmpty(String) |
| 3 | StringUtil | truncate | truncate(String, int) |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: StringUtil.isEmpty(body) / Expected: early-return
- Path: Main success path / Condition: - / Expected: success

