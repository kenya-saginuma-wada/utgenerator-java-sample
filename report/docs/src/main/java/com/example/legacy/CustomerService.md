# CustomerService

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 147 |
| Fields | 1 |
| Methods | 5 |
| High Complexity (>=15) | 0 |
| Dead Code Candidates | 0 |
| Duplicate Code Candidates | 0 |
| Removed API Usage | 0 |
| Cycle Involvement | 0 |
| Brittleness Signals | 0 |

## Class Overview

**How to read**: Check package/file location and class traits first to understand context before method-level details.

**Type**: Class

**Attributes**: Has inner classes

| Item | Value |
|------|----|
| Package | `com.example.legacy` |
| File | `src/main/java/com/example/legacy/CustomerService.java` |
| Lines | 147 |
| Methods | 5 |
| Fields | 1 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `customers` | `java.util.List<com.example.legacy.CustomerService.Customer>` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`addCustomer(Customer)`](#addcustomer-customer) | Public | 9 | 3 (Low) | - |
| [`findCustomerById(String)`](#findcustomerbyid-string) | Public | 13 | 4 (Low) | - |
| [`getActiveCustomers()`](#getactivecustomers) | Public | 15 | 5 (Low) | - |
| [`getCustomerCount()`](#getcustomercount) | Public | 3 | 1 (Low) | - |
| [`clearAllCustomers()`](#clearallcustomers) | Public | 3 | 1 (Low) | - |

---

### addCustomer(Customer)

**Summary**: Public / Parameters 1

```java
addCustomer(Customer)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | Customer customer |
| Output | void |
| Preconditions | customer == null / customer.getId() == null \|\| customer.getId().isEmpty() |
| Postconditions | Main success path -> success |
| Error/Boundary | customer.getId() == null => boundary / throws IllegalArgumentException |
| Dependencies | Customer#getId / List#add / String#isEmpty |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void addCustomer(Customer customer) {
    if (customer == null) {
        throw new IllegalArgumentException("Customer cannot be null");
    }
    if (customer.getId() == null || customer.getId().isEmpty()) {
        throw new IllegalArgumentException("Customer ID cannot be empty");
    }
    customers.add(customer);
}
```

| Metrics | Value |
|------------|----|
| Lines | 9 |
| Complexity | 3 (Low) |
| Nesting Depth | 1 |
| Parameters | 1 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | customer == null | 5:5 |
| fail-guard | customer.getId() == null \|\| customer.getId().isEmpty() | 8:5 |
| predicate | customer == null | - |
| predicate | customer.getId() == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | failure | customer == null | Exception throw path | failure |
| path-2 | failure | customer.getId() == null \|\| customer.getId().isEmpty() | Exception throw path | failure |
| path-4 | success | - | Main success path | success |
| path-3 | boundary | customer.getId() == null | Boundary condition customer.getId() == null | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | IllegalArgumentException | IllegalArgumentException | IllegalArgumentException(String) |
| 2 | List | add | add(E) |
| 3 | String | isEmpty | isEmpty() |
| 4 | Customer | getId | getId() |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `IllegalArgumentException`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Exception throw path / Condition: customer == null / Expected: failure
- Path: Exception throw path / Condition: customer.getId() == null || customer.getId().isEmpty() / Expected: failure
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition customer.getId() == null / Condition: customer.getId() == null / Expected: boundary
- Verify exception scenarios and messages.

### findCustomerById(String)

**Summary**: Public / Parameters 1

```java
findCustomerById(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String id |
| Output | Customer |
| Preconditions | id == null \|\| id.isEmpty() |
| Postconditions | Main success path -> success |
| Error/Boundary | id == null \|\| id.isEmpty() => early-return / id == null => boundary |
| Dependencies | Customer#getId / String#equals / String#isEmpty |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public Customer findCustomerById(String id) {
    if (id == null || id.isEmpty()) {
        return null;
    }
    for (Customer customer : customers) {
        if (customer.getId().equals(id)) {
            return customer;
        }
    }
    return null;
}
```

| Metrics | Value |
|------------|----|
| Lines | 13 |
| Complexity | 4 (Low) |
| Nesting Depth | 2 |
| Parameters | 1 |
| Call Count | 0 |
| Structure | Has loops Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | id == null \|\| id.isEmpty() | 5:5 |
| predicate | id == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | id == null \|\| id.isEmpty() | Early return path | early-return |
| path-3 | success | - | Main success path | success |
| path-2 | boundary | id == null | Boundary condition id == null | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | String | equals | equals(Object) |
| 2 | String | isEmpty | isEmpty() |
| 3 | Customer | getId | getId() |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: id == null || id.isEmpty() / Expected: early-return
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition id == null / Condition: id == null / Expected: boundary

### getActiveCustomers()

**Summary**: Public

```java
getActiveCustomers()
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | None |
| Output | List<Customer> |
| Preconditions | None |
| Postconditions | Returns List<Customer>. |
| Error/Boundary | None |
| Dependencies | Customer#isActive / ArrayList#ArrayList / Customer#getBalance |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public List<Customer> getActiveCustomers() {
    List<Customer> activeCustomers = new ArrayList<>();
    for (Customer customer : customers) {
        if (customer.isActive()) {
            if (customer.getBalance() > 0) {
                activeCustomers.add(customer);
            } else if (customer.isPremium()) {
                activeCustomers.add(customer);
            }
        }
    }
    return activeCustomers;
}
```

| Metrics | Value |
|------------|----|
| Lines | 15 |
| Complexity | 5 (Low) |
| Nesting Depth | 4 |
| Parameters | 0 |
| Call Count | 0 |
| Structure | Has loops Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| predicate | customer.getBalance() > 0 | - |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Customer | isActive | isActive() |
| 2 | List | add | add(E) |
| 3 | ArrayList | ArrayList | ArrayList() |
| 4 | Customer | getBalance | getBalance() |
| 5 | Customer | isPremium | isPremium() |
| 6 | List | add | add(Object) |

### getCustomerCount()

**Summary**: Public

```java
getCustomerCount()
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
| Dependencies | List#size |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public int getCustomerCount() {
    return customers.size();
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | List | size | size() |

### clearAllCustomers()

**Summary**: Public

```java
clearAllCustomers()
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
| Dependencies | List#clear |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public void clearAllCustomers() {
    customers.clear();
}
```

| Metrics | Value |
|------------|----|
| Lines | 3 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 0 |
| Call Count | 0 |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | List | clear | clear() |

