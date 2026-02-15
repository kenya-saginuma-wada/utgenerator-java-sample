# OrderProcessingService Detailed Design

## 1. Purpose and Responsibilities (Facts)
The `OrderProcessingService` class is responsible for processing orders by validating input parameters and printing a confirmation message.

## 2. External Class Specification
- Class Name: `OrderProcessingService`
- Package: `com.example.legacy`
- File Path: `src/main/java/com/example/legacy/OrderProcessingService.java`
- Class Type: Class
- Extends: None
- Implements: None
- Class Attributes:
  - nested_class: false
  - anonymous_class: false
  - has_nested_classes: false
  - enclosing_type: none
- Fields:
  - `supportedCurrencies`: java.util.List<java.lang.String> (Private)

## 3. Method Specifications

### 3.1 getSupportedCurrencies
#### 3.1.1 Inputs/Outputs
- Signature: `getSupportedCurrencies()`

#### 3.1.2 Preconditions
- None

#### 3.1.3 Postconditions
- Returns `supportedCurrencies` directly.

#### 3.1.4 Normal Flow
- `getSupportedCurrencies` returns `supportedCurrencies`.

#### 3.1.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.1.6 Dependencies
- None

#### 3.1.7 Test Viewpoints
- Verify that `getSupportedCurrencies` returns `supportedCurrencies`.

### 3.2 processOrder
#### 3.2.1 Inputs/Outputs
- **Inputs**:
  - `orderId`: `String`
  - `amount`: `double`
  - `currency`: `String`
- **Outputs**:
  - None (prints a message to the console)

#### 3.2.2 Preconditions
- `orderId` must not be null.
- `orderId` must not be empty.
- `amount` must be greater than 0.
- `currency` must not be null.
- `currency` must be contained in `supportedCurrencies`.
- orderId != null
- currency != null
- !orderId.isEmpty()
- amount > 0
- supportedCurrencies.contains(currency)

#### 3.2.3 Postconditions
- A message is printed to the console confirming the order processing.

#### 3.2.4 Normal Flow
1. Validate that `orderId` is not null and not empty.
2. Validate that `amount` is greater than 0.
3. Validate that `currency` is not null and is supported.
4. Print a message indicating successful order processing.

#### 3.2.5 Error/Boundary Handling
- If `orderId` is null, an exception is thrown with the message "Order ID cannot be null".
- If `orderId` is empty, an exception is thrown with the message "Order ID cannot be empty".
- If `amount` is not greater than 0, an exception is thrown with the message "Amount must be positive: %s".
- If `currency` is null, an exception is thrown with the message "Currency cannot be null".
- If `currency` is not supported, an exception is thrown with the message "Unsupported currency: %s".

#### 3.2.6 Dependencies
- `java.io.PrintStream#println(java.lang.String)`
- `java.util.List#contains(java.lang.Object)`
- `com.google.common.base.Preconditions#checkArgument(boolean, java.lang.Object)`
- `com.google.common.base.Preconditions#checkArgument(boolean, java.lang.String, java.lang.Object)`
- `java.lang.String#isEmpty()`
- `com.google.common.base.Preconditions#checkNotNull(T, java.lang.Object)`

#### 3.2.7 Test Viewpoints
- Test with valid `orderId`, `amount`, and `currency`.
- Test with `orderId` as null.
- Test with empty `orderId`.
- Test with `amount` less than or equal to 0.
- Test with `currency` as null.
- Test with unsupported `currency`.

## 4. Cautions
- None

## 5. Recommendations (Optional)
- None

## 6. Open Questions (Insufficient Analysis)
- None