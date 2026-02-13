# OrderService

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 59 |
| Fields | 2 |
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
| Package | `com.example.legacy.service` |
| File | `src/main/java/com/example/legacy/service/OrderService.java` |
| Lines | 59 |
| Methods | 3 |
| Fields | 2 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `orderRepository` | `com.example.legacy.service.OrderRepository` | Private |
| `notificationService` | `com.example.legacy.service.NotificationService` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`OrderService(OrderRepository, NotificationService)`](#orderservice-orderrepository-notificationservice) | Public | 4 | 1 (Low) | - |
| [`processOrder(String)`](#processorder-string) | Public | 19 | 3 (Low) | - |
| [`cancelOrder(String)`](#cancelorder-string) | Public | 16 | 3 (Low) | - |

---

### OrderService(OrderRepository, NotificationService)

**Summary**: Public / Parameters 2

```java
OrderService(OrderRepository, NotificationService)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | OrderRepository orderRepository / NotificationService notificationService |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
    this.orderRepository = orderRepository;
    this.notificationService = notificationService;
}
```

| Metrics | Value |
|------------|----|
| Lines | 4 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 2 |
| Call Count | 0 |

### processOrder(String)

**Summary**: Public / Parameters 1

```java
processOrder(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String orderId |
| Output | boolean |
| Preconditions | orderId == null \|\| orderId.isBlank() / order == null |
| Postconditions | Main success path -> success |
| Error/Boundary | orderId == null \|\| orderId.isBlank() => early-return / order == null => early-return / orderId == null => boundary |
| Dependencies | OrderRepository#save / NotificationService#sendNotification / OrderRepository#findById |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public boolean processOrder(String orderId) {
    if (orderId == null || orderId.isBlank()) {
        return false;
    }
    var order = orderRepository.findById(orderId);
    if (order == null) {
        return false;
    }

    order.setStatus("PROCESSING");
    orderRepository.save(order);

    notificationService.sendNotification(orderId, "Order is being processed");
    return true;
}
```

| Metrics | Value |
|------------|----|
| Lines | 19 |
| Complexity | 3 (Low) |
| Nesting Depth | 1 |
| Parameters | 1 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | orderId == null \|\| orderId.isBlank() | 8:5 |
| fail-guard | order == null | 12:5 |
| predicate | order == null | - |
| predicate | orderId == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | orderId == null \|\| orderId.isBlank() | Early return path | early-return |
| path-2 | early-return | order == null | Early return path | early-return |
| path-4 | success | - | Main success path | success |
| path-3 | boundary | orderId == null | Boundary condition orderId == null | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | OrderRepository | save | save(Order) |
| 2 | NotificationService | sendNotification | sendNotification(String, String) |
| 3 | OrderRepository | findById | findById(String) |
| 4 | String | isBlank | isBlank() |
| 5 | Order | setStatus | setStatus(String) |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: orderId == null || orderId.isBlank() / Expected: early-return
- Path: Early return path / Condition: order == null / Expected: early-return
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition orderId == null / Condition: orderId == null / Expected: boundary

### cancelOrder(String)

**Summary**: Public / Parameters 1

```java
cancelOrder(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String orderId |
| Output | boolean |
| Preconditions | orderId == null / order == null |
| Postconditions | Main success path -> success |
| Error/Boundary | orderId == null => early-return / order == null => early-return |
| Dependencies | OrderRepository#save / NotificationService#sendNotification / OrderRepository#findById |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public boolean cancelOrder(String orderId) {
    if (orderId == null) {
        return false;
    }
    var order = orderRepository.findById(orderId);
    if (order == null) {
        return false;
    }
    order.setStatus("CANCELLED");
    orderRepository.save(order);
    notificationService.sendNotification(orderId, "Order has been cancelled");
    return true;
}
```

| Metrics | Value |
|------------|----|
| Lines | 16 |
| Complexity | 3 (Low) |
| Nesting Depth | 1 |
| Parameters | 1 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | orderId == null | 8:5 |
| fail-guard | order == null | 12:5 |
| predicate | order == null | - |
| predicate | orderId == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | orderId == null | Early return path | early-return |
| path-2 | early-return | order == null | Early return path | early-return |
| path-3 | success | - | Main success path | success |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | OrderRepository | save | save(Order) |
| 2 | NotificationService | sendNotification | sendNotification(String, String) |
| 3 | OrderRepository | findById | findById(String) |
| 4 | Order | setStatus | setStatus(String) |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: orderId == null / Expected: early-return
- Path: Early return path / Condition: order == null / Expected: early-return
- Path: Main success path / Condition: - / Expected: success

