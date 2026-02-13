# DynamicTestPatterns

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 81 |
| Fields | 0 |
| Methods | 8 |
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
| File | `src/main/java/com/example/legacy/DynamicTestPatterns.java` |
| Lines | 81 |
| Methods | 8 |
| Fields | 0 |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`loadClassByName()`](#loadclassbyname) | Public | 5 | 1 (Low) | - |
| [`getMethodByLiteral()`](#getmethodbyliteral) | Public | 4 | 1 (Low) | - |
| [`getDeclaredMethodExample()`](#getdeclaredmethodexample) | Public | 5 | 1 (Low) | - |
| [`invokeMethod(Object)`](#invokemethod-object) | Public | 5 | 1 (Low) | - |
| [`loadService()`](#loadservice) | Public | 8 | 2 (Low) | - |
| [`loadClassByVariable(String)`](#loadclassbyvariable-string) | Public | 5 | 1 (Low) | - |
| [`loadClassByConcatenation(String)`](#loadclassbyconcatenation-string) | Public | 5 | 1 (Low) | - |
| [`getMethodByVariable(String)`](#getmethodbyvariable-string) | Public | 4 | 1 (Low) | - |

---

### loadClassByName()

**Summary**: Public

```java
loadClassByName()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | Object |
| Preconditions | None |
| Postconditions | Returns Object. |
| Error/Boundary | throws Exception |
| Dependencies | Class#getDeclaredConstructor / Class#forName / Constructor#newInstance |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Object loadClassByName() throws Exception {

    Class<?> clazz = Class.forName("com.example.legacy.CustomerService");
    return clazz.getDeclaredConstructor().newInstance();
}
```

| Metrics | Value |
|------------|----|
| Lines | 5 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Class | getDeclaredConstructor | getDeclaredConstructor(java.lang.Class...) |
| 2 | Class | forName | forName(String) |
| 3 | Constructor | newInstance | newInstance(java.lang.Object...) |
| 4 | Constructor | newInstance | newInstance(Object[]) |
| 5 | Class | getDeclaredConstructor | getDeclaredConstructor(Class[]) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `Exception`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Verify exception scenarios and messages.

### getMethodByLiteral()

**Summary**: Public

```java
getMethodByLiteral()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | Method |
| Preconditions | None |
| Postconditions | Returns Method. |
| Error/Boundary | throws Exception |
| Dependencies | Class#getMethod / Class#getMethod |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Method getMethodByLiteral() throws Exception {

    return CustomerService.class.getMethod("processCustomer", String.class);
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
| 1 | Class | getMethod | getMethod(String, java.lang.Class...) |
| 2 | Class | getMethod | getMethod(String, Class[]) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `Exception`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Verify exception scenarios and messages.

### getDeclaredMethodExample()

**Summary**: Public

```java
getDeclaredMethodExample()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | Method |
| Preconditions | None |
| Postconditions | Returns Method. |
| Error/Boundary | throws Exception |
| Dependencies | Class#forName / Class#getDeclaredMethod / Class#getDeclaredMethod |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Method getDeclaredMethodExample() throws Exception {
    Class<?> clazz = Class.forName("com.example.legacy.util.StringUtil");

    return clazz.getDeclaredMethod("truncate", String.class, int.class);
}
```

| Metrics | Value |
|------------|----|
| Lines | 5 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Class | forName | forName(String) |
| 2 | Class | getDeclaredMethod | getDeclaredMethod(String, java.lang.Class...) |
| 3 | Class | getDeclaredMethod | getDeclaredMethod(String, Class[]) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `Exception`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Verify exception scenarios and messages.

### invokeMethod(Object)

**Summary**: Public / Parameters 1

```java
invokeMethod(Object)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | Object target |
| Output | Object |
| Preconditions | None |
| Postconditions | Returns Object. |
| Error/Boundary | throws Exception |
| Dependencies | Class#getMethod / Method#invoke / Method#invoke |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Object invokeMethod(Object target) throws Exception {
    Method method = CustomerService.class.getMethod("processCustomer", String.class);

    return method.invoke(target, "test");
}
```

| Metrics | Value |
|------------|----|
| Lines | 5 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Class | getMethod | getMethod(String, java.lang.Class...) |
| 2 | Method | invoke | invoke(Object, java.lang.Object...) |
| 3 | Method | invoke | invoke(Object, Object[]) |
| 4 | Class | getMethod | getMethod(String, Class[]) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `Exception`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Verify exception scenarios and messages.

### loadService()

**Summary**: Public

```java
loadService()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | void |
| Preconditions | None |
| Postconditions | Unknown |
| Error/Boundary | None |
| Dependencies | ServiceLoader#load / PrintStream#println |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void loadService() {


    ServiceLoader<CustomerService> loader = ServiceLoader.load(CustomerService.class);
    for (CustomerService service : loader) {
        System.out.println(service);
    }
}
```

| Metrics | Value |
|------------|----|
| Lines | 8 |
| Complexity | 2 (Low) |
| Nesting Depth | 1 |
| Parameters | 0 |
| Call Count | 0 |
| Structure | Has loops |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | ServiceLoader | load | load(Class) |
| 2 | PrintStream | println | println(Object) |

### loadClassByVariable(String)

**Summary**: Public / Parameters 1

```java
loadClassByVariable(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String className |
| Output | Object |
| Preconditions | None |
| Postconditions | Returns Object. |
| Error/Boundary | throws Exception |
| Dependencies | Class#getDeclaredConstructor / Class#forName / Constructor#newInstance |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Object loadClassByVariable(String className) throws Exception {

    Class<?> clazz = Class.forName(className);
    return clazz.getDeclaredConstructor().newInstance();
}
```

| Metrics | Value |
|------------|----|
| Lines | 5 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Class | getDeclaredConstructor | getDeclaredConstructor(java.lang.Class...) |
| 2 | Class | forName | forName(String) |
| 3 | Constructor | newInstance | newInstance(java.lang.Object...) |
| 4 | Constructor | newInstance | newInstance(Object[]) |
| 5 | Class | getDeclaredConstructor | getDeclaredConstructor(Class[]) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `Exception`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Verify exception scenarios and messages.

### loadClassByConcatenation(String)

**Summary**: Public / Parameters 1

```java
loadClassByConcatenation(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String suffix |
| Output | Object |
| Preconditions | None |
| Postconditions | Returns Object. |
| Error/Boundary | throws Exception |
| Dependencies | Class#getDeclaredConstructor / Class#forName / Constructor#newInstance |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Object loadClassByConcatenation(String suffix) throws Exception {

    Class<?> clazz = Class.forName("com.example." + suffix);
    return clazz.getDeclaredConstructor().newInstance();
}
```

| Metrics | Value |
|------------|----|
| Lines | 5 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Class | getDeclaredConstructor | getDeclaredConstructor(java.lang.Class...) |
| 2 | Class | forName | forName(String) |
| 3 | Constructor | newInstance | newInstance(java.lang.Object...) |
| 4 | Constructor | newInstance | newInstance(Object[]) |
| 5 | Class | getDeclaredConstructor | getDeclaredConstructor(Class[]) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `Exception`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Verify exception scenarios and messages.

### getMethodByVariable(String)

**Summary**: Public / Parameters 1

```java
getMethodByVariable(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String methodName |
| Output | Method |
| Preconditions | None |
| Postconditions | Returns Method. |
| Error/Boundary | throws Exception |
| Dependencies | Class#getMethod / Class#getMethod |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Method getMethodByVariable(String methodName) throws Exception {

    return CustomerService.class.getMethod(methodName);
}
```

| Metrics | Value |
|------------|----|
| Lines | 4 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 1 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Class | getMethod | getMethod(String, java.lang.Class...) |
| 2 | Class | getMethod | getMethod(String, Class[]) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `Exception`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Verify exception scenarios and messages.

