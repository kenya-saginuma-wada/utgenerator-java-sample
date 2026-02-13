# PaymentService

## Analysis Summary

**How to read**: Start with high complexity, dead code, duplicate, and brittleness counts to prioritize risky areas.

| Metric | Value |
|------|----|
| Type | Class |
| Lines | 300 |
| Fields | 3 |
| Methods | 4 |
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
| File | `src/main/java/com/example/legacy/PaymentService.java` |
| Lines | 300 |
| Methods | 4 |
| Fields | 3 |

## Fields

**How to read**: Review field types and visibility to understand state ownership and dependency boundaries.

| Name | Type | Visibility |
|------|-----|--------|
| `paymentGateway` | `com.example.legacy.PaymentService.PaymentGateway` | Private |
| `notificationService` | `com.example.legacy.PaymentService.NotificationService` | Private |
| `paymentRepository` | `com.example.legacy.PaymentService.PaymentRepository` | Private |

## Methods

**How to read**: Use this table to find longer or more complex methods, then jump to the detailed sections.

| Method | Visibility | Lines | Complexity | Notes |
|----------|--------|------|--------|------|
| [`PaymentService(PaymentGateway, NotificationService, PaymentRepository)`](#paymentservice-paymentgateway-notificationservice-paymentrepository) | Public | 7 | 1 (Low) | - |
| [`processPayment(String, BigDecimal, String, String)`](#processpayment-string-bigdecimal-string-string) | Public | 45 | 7 (Medium) | - |
| [`refundPayment(String, BigDecimal)`](#refundpayment-string-bigdecimal) | Public | 30 | 6 (Medium) | - |
| [`getPaymentHistory(String)`](#getpaymenthistory-string) | Public | 6 | 2 (Low) | - |

---

### PaymentService(PaymentGateway, NotificationService, PaymentRepository)

**Summary**: Public / Parameters 3

```java
PaymentService(PaymentGateway, NotificationService, PaymentRepository)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | PaymentGateway paymentGateway / NotificationService notificationService / PaymentRepository paymentRepository |
| Output | Constructs instance |
| Preconditions | None |
| Postconditions | Instance is initialized. |
| Error/Boundary | None |
| Dependencies | None |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public PaymentService(PaymentGateway paymentGateway, NotificationService notificationService, PaymentRepository paymentRepository) {
    this.paymentGateway = paymentGateway;
    this.notificationService = notificationService;
    this.paymentRepository = paymentRepository;
}
```

| Metrics | Value |
|------------|----|
| Lines | 7 |
| Complexity | 1 (Low) |
| Nesting Depth | 0 |
| Parameters | 3 |
| Call Count | 0 |

### processPayment(String, BigDecimal, String, String)

**Summary**: Public / Parameters 4

```java
processPayment(String, BigDecimal, String, String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String orderId / BigDecimal amount / String customerId / and 1 more |
| Output | PaymentResult |
| Preconditions | orderId == null \|\| orderId.isBlank() / amount == null \|\| amount.compareTo(BigDecimal.ZERO) <= 0 / customerId == null \|\| customerId.isBlank() / and 1 more |
| Postconditions | Main success path -> success |
| Error/Boundary | orderId == null \|\| orderId.isBlank() => early-return / amount == null \|\| amount.compareTo(BigDecimal.ZERO) <= 0 => early-return / customerId == null \|\| customerId.isBlank() => early-return / and 5 more |
| Dependencies | GatewayResponse#getTransactionId / Payment#getStatus / PaymentRepository#save |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public PaymentResult processPayment(String orderId, BigDecimal amount, String customerId, String paymentMethod) {

    if (orderId == null || orderId.isBlank()) {
        return PaymentResult.failure("Order ID is required");
    }
    if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
        return PaymentResult.failure("Amount must be positive");
    }
    if (customerId == null || customerId.isBlank()) {
        return PaymentResult.failure("Customer ID is required");
    }
    if (!isValidPaymentMethod(paymentMethod)) {
        return PaymentResult.failure("Invalid payment method: " + paymentMethod);
    }

    Optional<Payment> existingPayment = paymentRepository.findByOrderId(orderId);
    if (existingPayment.isPresent() && existingPayment.get().getStatus().equals("COMPLETED")) {
        return PaymentResult.failure("Payment already processed for order: " + orderId);
    }

    GatewayResponse gatewayResponse = paymentGateway.charge(customerId, amount, paymentMethod);
    if (!gatewayResponse.isSuccess()) {
        return PaymentResult.failure("Payment gateway error: " + gatewayResponse.getErrorMessage());
    }

    Payment payment = new Payment(gatewayResponse.getTransactionId(), orderId, customerId, amount, paymentMethod, "COMPLETED", LocalDateTime.now());
    paymentRepository.save(payment);

    notificationService.sendPaymentConfirmation(customerId, orderId, amount);
    return PaymentResult.success(gatewayResponse.getTransactionId(), amount);
}
```

| Metrics | Value |
|------------|----|
| Lines | 45 |
| Complexity | 7 (Medium) |
| Nesting Depth | 1 |
| Parameters | 4 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | orderId == null \|\| orderId.isBlank() | 13:5 |
| fail-guard | amount == null \|\| amount.compareTo(BigDecimal.ZERO) <= 0 | 16:5 |
| fail-guard | customerId == null \|\| customerId.isBlank() | 19:5 |
| fail-guard | !isValidPaymentMethod(paymentMethod) | 22:5 |
| predicate | amount == null | - |
| predicate | amount.compareTo(BigDecimal.ZERO) <= 0 | - |
| predicate | customerId == null | - |
| predicate | orderId == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | orderId == null \|\| orderId.isBlank() | Early return path | early-return |
| path-2 | early-return | amount == null \|\| amount.compareTo(BigDecimal.ZERO) <= 0 | Early return path | early-return |
| path-3 | early-return | customerId == null \|\| customerId.isBlank() | Early return path | early-return |
| path-4 | early-return | !isValidPaymentMethod(paymentMethod) | Early return path | early-return |
| path-9 | success | - | Main success path | success |
| path-5 | boundary | amount == null | Boundary condition amount == null | boundary |
| path-6 | boundary | amount.compareTo(BigDecimal.ZERO) <= 0 | Boundary condition amount.compareTo(BigDecimal.ZERO) <= 0 | boundary |
| path-7 | boundary | customerId == null | Boundary condition customerId == null | boundary |
| ... | ... | ... | ... | and 1 more |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Optional | get | get() |
| 2 | GatewayResponse | getTransactionId | getTransactionId() |
| 3 | String | isBlank | isBlank() |
| 4 | Payment | getStatus | getStatus() |
| 5 | PaymentRepository | save | save(Payment) |
| 6 | Payment | Payment | Payment(String, String, String, BigDecimal, ...) |
| 7 | String | equals | equals(Object) |
| 8 | GatewayResponse | getErrorMessage | getErrorMessage() |
| 9 | BigDecimal | compareTo | compareTo(BigDecimal) |
| 10 | NotificationService | sendPaymentConfirmation | sendPaymentConfirmation(String, String, BigDecimal) |
| ... | ... | ... | and 8 more |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: orderId == null || orderId.isBlank() / Expected: early-return
- Path: Early return path / Condition: amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 / Expected: early-return
- Path: Early return path / Condition: customerId == null || customerId.isBlank() / Expected: early-return
- Path: Early return path / Condition: !isValidPaymentMethod(paymentMethod) / Expected: early-return
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition amount == null / Condition: amount == null / Expected: boundary
- Path: Boundary condition amount.compareTo(BigDecimal.ZERO) <= 0 / Condition: amount.compareTo(BigDecimal.ZERO) <= 0 / Expected: boundary
- Path: Boundary condition customerId == null / Condition: customerId == null / Expected: boundary
- and 1 more

### refundPayment(String, BigDecimal)

**Summary**: Public / Parameters 2

```java
refundPayment(String, BigDecimal)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String transactionId / BigDecimal refundAmount |
| Output | RefundResult |
| Preconditions | transactionId == null \|\| transactionId.isBlank() / paymentOpt.isEmpty() |
| Postconditions | Main success path -> success |
| Error/Boundary | transactionId == null \|\| transactionId.isBlank() => early-return / paymentOpt.isEmpty() => early-return / transactionId == null => boundary |
| Dependencies | Payment#getCustomerId / PaymentGateway#refund / RefundResult#success |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public RefundResult refundPayment(String transactionId, BigDecimal refundAmount) {
    if (transactionId == null || transactionId.isBlank()) {
        return RefundResult.failure("Transaction ID is required");
    }
    Optional<Payment> paymentOpt = paymentRepository.findByTransactionId(transactionId);
    if (paymentOpt.isEmpty()) {
        return RefundResult.failure("Payment not found: " + transactionId);
    }
    Payment payment = paymentOpt.get();
    BigDecimal actualRefundAmount = refundAmount != null ? refundAmount : payment.getAmount();
    if (actualRefundAmount.compareTo(payment.getAmount()) > 0) {
        return RefundResult.failure("Refund amount exceeds original payment");
    }
    GatewayResponse refundResponse = paymentGateway.refund(transactionId, actualRefundAmount);
    if (!refundResponse.isSuccess()) {
        return RefundResult.failure("Refund failed: " + refundResponse.getErrorMessage());
    }
    payment.setStatus("REFUNDED");
    paymentRepository.save(payment);
    notificationService.sendRefundConfirmation(payment.getCustomerId(), payment.getOrderId(), actualRefundAmount);
    return RefundResult.success(refundResponse.getTransactionId(), actualRefundAmount);
}
```

| Metrics | Value |
|------------|----|
| Lines | 30 |
| Complexity | 6 (Medium) |
| Nesting Depth | 1 |
| Parameters | 2 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | transactionId == null \|\| transactionId.isBlank() | 9:5 |
| fail-guard | paymentOpt.isEmpty() | 13:5 |
| predicate | actualRefundAmount.compareTo(payment.getAmount()) > 0 | - |
| predicate | refundAmount != null | - |
| predicate | transactionId == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | early-return | transactionId == null \|\| transactionId.isBlank() | Early return path | early-return |
| path-2 | early-return | paymentOpt.isEmpty() | Early return path | early-return |
| path-4 | success | - | Main success path | success |
| path-3 | boundary | transactionId == null | Boundary condition transactionId == null | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | Payment | getCustomerId | getCustomerId() |
| 2 | PaymentGateway | refund | refund(String, BigDecimal) |
| 3 | RefundResult | success | success(String, BigDecimal) |
| 4 | Optional | get | get() |
| 5 | Payment | setStatus | setStatus(String) |
| 6 | RefundResult | failure | failure(String) |
| 7 | Payment | getOrderId | getOrderId() |
| 8 | Optional | isEmpty | isEmpty() |
| 9 | GatewayResponse | getTransactionId | getTransactionId() |
| 10 | String | isBlank | isBlank() |
| ... | ... | ... | and 7 more |

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Early return path / Condition: transactionId == null || transactionId.isBlank() / Expected: early-return
- Path: Early return path / Condition: paymentOpt.isEmpty() / Expected: early-return
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition transactionId == null / Condition: transactionId == null / Expected: boundary

### getPaymentHistory(String)

**Summary**: Public / Parameters 1

```java
getPaymentHistory(String)
```

**Method Contract**:
**How to read**: Use this contract as the specification baseline for I/O, constraints, and dependency behavior.

| Item | Value |
|------|------|
| Inputs | String customerId |
| Output | List<Payment> |
| Preconditions | customerId == null \|\| customerId.isBlank() |
| Postconditions | Main success path -> success |
| Error/Boundary | customerId == null => boundary / throws IllegalArgumentException |
| Dependencies | PaymentRepository#findByCustomerId / String#isBlank |

**Source Code**:

**How to read**: Read control flow and side effects carefully, especially input guards, external calls, and state changes.

```java
public List<Payment> getPaymentHistory(String customerId) {
    if (customerId == null || customerId.isBlank()) {
        throw new IllegalArgumentException("Customer ID is required");
    }
    return paymentRepository.findByCustomerId(customerId);
}
```

| Metrics | Value |
|------------|----|
| Lines | 6 |
| Complexity | 2 (Low) |
| Nesting Depth | 1 |
| Parameters | 1 |
| Call Count | 0 |
| Structure | Has conditionals |

**Branches/Guards**:
**How to read**: Focus on guard conditions and notes to identify missing edge-case tests and early-return paths.

| Type | Condition | Notes |
|------|------|------|
| fail-guard | customerId == null \|\| customerId.isBlank() | 5:5 |
| predicate | customerId == null | - |

**Representative Paths**:

**How to read**: Use path type, condition, and expected result to design explicit test scenarios.

| ID | Type | Condition | Description | Notes |
|----|------|------|------|------|
| path-1 | failure | customerId == null \|\| customerId.isBlank() | Exception throw path | failure |
| path-3 | success | - | Main success path | success |
| path-2 | boundary | customerId == null | Boundary condition customerId == null | boundary |

**Called Methods**:
**How to read**: Check owners and signatures to understand coupling, mock targets, and integration impact.

| # | Owner | Method | Signature |
|---|------|------|-----------|
| 1 | IllegalArgumentException | IllegalArgumentException | IllegalArgumentException(String) |
| 2 | String | isBlank | isBlank() |
| 3 | PaymentRepository | findByCustomerId | findByCustomerId(String) |

**Exceptions**:
**How to read**: Use exception lists to verify negative scenarios and expected failure behavior.

- `IllegalArgumentException`

**Test Viewpoints**:
**How to read**: Turn each path and signal into explicit test scenarios for normal, error, and boundary behavior.

- Path: Exception throw path / Condition: customerId == null || customerId.isBlank() / Expected: failure
- Path: Main success path / Condition: - / Expected: success
- Path: Boundary condition customerId == null / Condition: customerId == null / Expected: boundary
- Verify exception scenarios and messages.

