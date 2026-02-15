# CustomerService Detailed Design

## 1. Purpose and Responsibilities (Facts)
The `CustomerService` class is responsible for managing customer data, including adding customers, clearing all customers, finding a customer by ID, and retrieving active customers.

## 2. External Class Specification
- Class Name: `CustomerService`
- Package: `com.example.legacy`
- File Path: `src/main/java/com/example/legacy/CustomerService.java`
- Class Type: Class
- Extends: None
- Implements: None
- Class Attributes:
  - nested_class: false
  - anonymous_class: false
  - has_nested_classes: true
  - enclosing_type: none
- Fields:
  - `customers`: java.util.List<com.example.legacy.CustomerService.Customer> (Private)

## 3. Method Specifications

### 3.1 addCustomer
#### 3.1.1 Inputs/Outputs
- **Inputs**: `Customer customer`
- **Outputs**: None

#### 3.1.2 Preconditions
- `customer != null`
- `customer.getId() != null && !customer.getId().isEmpty()`

#### 3.1.3 Postconditions
- The `customer` is added to the `customers` list.

#### 3.1.4 Normal Flow
- The method checks if the `customer` and `customer.getId()` are not null and not empty.
- Adds the `customer` to the `customers` list.

#### 3.1.5 Error/Boundary Handling
- Throws `IllegalArgumentException` if `customer` is null.
- Throws `IllegalArgumentException` if `customer.getId()` is null or empty.

#### 3.1.6 Dependencies
- `java.util.List#add(E)`
- `com.example.legacy.CustomerService.Customer#getId()`
- `java.lang.String#isEmpty()`

#### 3.1.7 Test Viewpoints
- Test with a valid `customer` object.
- Test with `customer` as null.
- Test with `customer.getId()` as null or empty.

### 3.2 clearAllCustomers
#### 3.2.1 Inputs/Outputs
- **Inputs**: None
- **Outputs**: None

#### 3.2.2 Preconditions
- None

#### 3.2.3 Postconditions
- The `customers` list is cleared.

#### 3.2.4 Normal Flow
- Clears the `customers` list.

#### 3.2.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.2.6 Dependencies
- `java.util.List#clear()`

#### 3.2.7 Test Viewpoints
- Test when `customers` list is empty.
- Test when `customers` list has multiple entries.

### 3.3 findCustomerById
#### 3.3.1 Inputs/Outputs
- **Inputs**: `String id`
- **Outputs**: `Customer`

#### 3.3.2 Preconditions
- `id != null && !id.isEmpty()`

#### 3.3.3 Postconditions
- Returns a `Customer` object if found, otherwise returns null.

#### 3.3.4 Normal Flow
- Iterates over the `customers` list to find a `Customer` with the matching `id`.

#### 3.3.5 Error/Boundary Handling
- Returns null if `id` is null or empty.
- Returns null if no matching `Customer` is found.

#### 3.3.6 Dependencies
- `com.example.legacy.CustomerService.Customer#getId()`
- `java.lang.String#equals(java.lang.Object)`
- `java.lang.String#isEmpty()`

#### 3.3.7 Test Viewpoints
- Test with a valid `id` that exists in the list.
- Test with a valid `id` that does not exist in the list.
- Test with `id` as null or empty.

### 3.4 getActiveCustomers
#### 3.4.1 Inputs/Outputs
- **Inputs**: None
- **Outputs**: `List<Customer>`

#### 3.4.2 Preconditions
- None

#### 3.4.3 Postconditions
- Returns a list of active `Customer` objects.

#### 3.4.4 Normal Flow
- Iterates over the `customers` list and adds active customers to a new list based on balance and premium status.

#### 3.4.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.4.6 Dependencies
- `com.example.legacy.CustomerService.Customer#isActive()`
- `com.example.legacy.CustomerService.Customer#getBalance()`
- `com.example.legacy.CustomerService.Customer#isPremium()`
- `java.util.List#add(E)`
- `java.util.ArrayList#ArrayList()`

#### 3.4.7 Test Viewpoints
- Test with no active customers.
- Test with all customers active.
- Test with a mix of active and inactive customers.

### 3.5 getCustomerCount
#### 3.5.1 Inputs/Outputs
- Signature: `getCustomerCount()`

#### 3.5.2 Preconditions
- None

#### 3.5.3 Postconditions
- Returns `writer.toString()` directly.

#### 3.5.4 Normal Flow
- `getCustomerCount` returns `writer.toString()`.

#### 3.5.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.5.6 Dependencies
- None

#### 3.5.7 Test Viewpoints
- Verify that `getCustomerCount` returns `writer.toString()`.

## 4. Cautions
- None

## 5. Recommendations (Optional)
- None

## 6. Open Questions (Insufficient Analysis)
- None