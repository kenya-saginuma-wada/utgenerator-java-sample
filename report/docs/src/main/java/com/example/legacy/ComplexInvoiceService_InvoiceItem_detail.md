# InvoiceItem Detailed Design

## 1. Purpose and Responsibilities (Facts)
The `InvoiceItem` class is a nested class within `ComplexInvoiceService`. It is responsible for representing an item in an invoice with attributes such as item ID, category, unit price, quantity, and flags for taxability and discountability.

## 2. External Class Specification
- Class Name: `InvoiceItem`
- Package: `com.example.legacy`
- File Path: `src/main/java/com/example/legacy/ComplexInvoiceService.java`
- Class Type: Class
- Extends: None
- Implements: None
- Class Attributes:
  - nested_class: true
  - anonymous_class: false
  - has_nested_classes: false
  - enclosing_type: `ComplexInvoiceService`
- Fields:
  - `itemId`: java.lang.String (Private)
  - `category`: java.lang.String (Private)
  - `unitPrice`: double (Private)
  - `quantity`: int (Private)
  - `isTaxable`: boolean (Private)
  - `isDiscountable`: boolean (Private)

## 3. Method Specifications

### 3.1 InvoiceItem
#### 3.1.1 Inputs/Outputs
- **Inputs**:
  - `itemId`: String
  - `category`: String
  - `unitPrice`: double
  - `quantity`: int
  - `isTaxable`: boolean
  - `isDiscountable`: boolean
- **Outputs**:
  - An instance of `InvoiceItem` is created.

#### 3.1.2 Preconditions
- None

#### 3.1.3 Postconditions
- The `InvoiceItem` instance is initialized with the provided parameters.

#### 3.1.4 Normal Flow
1. The constructor is called with the specified parameters.
2. The fields `itemId`, `category`, `unitPrice`, `quantity`, `isTaxable`, and `isDiscountable` are set to the provided values.

#### 3.1.5 Error/Boundary Handling
- The constructor does not handle any errors or boundary conditions explicitly.

#### 3.1.6 Dependencies
- None

#### 3.1.7 Test Viewpoints
- Verify that an `InvoiceItem` instance is correctly initialized with the given parameters.
- Check that each field is set to the expected value after construction.

### 3.2 getCategory
#### 3.2.1 Inputs/Outputs
- Signature: `getCategory()`

#### 3.2.2 Preconditions
- None

#### 3.2.3 Postconditions
- Returns `category` directly.

#### 3.2.4 Normal Flow
- `getCategory` returns `category`.

#### 3.2.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.2.6 Dependencies
- None

#### 3.2.7 Test Viewpoints
- Verify that `getCategory` returns `category`.

### 3.3 getItemId
#### 3.3.1 Inputs/Outputs
- Signature: `getItemId()`

#### 3.3.2 Preconditions
- None

#### 3.3.3 Postconditions
- Returns `itemId` directly.

#### 3.3.4 Normal Flow
- `getItemId` returns `itemId`.

#### 3.3.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.3.6 Dependencies
- None

#### 3.3.7 Test Viewpoints
- Verify that `getItemId` returns `itemId`.

### 3.4 getQuantity
#### 3.4.1 Inputs/Outputs
- Signature: `getQuantity()`

#### 3.4.2 Preconditions
- None

#### 3.4.3 Postconditions
- Returns `quantity` directly.

#### 3.4.4 Normal Flow
- `getQuantity` returns `quantity`.

#### 3.4.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.4.6 Dependencies
- None

#### 3.4.7 Test Viewpoints
- Verify that `getQuantity` returns `quantity`.

### 3.5 getUnitPrice
#### 3.5.1 Inputs/Outputs
- Signature: `getUnitPrice()`

#### 3.5.2 Preconditions
- None

#### 3.5.3 Postconditions
- Returns `unitPrice` directly.

#### 3.5.4 Normal Flow
- `getUnitPrice` returns `unitPrice`.

#### 3.5.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.5.6 Dependencies
- None

#### 3.5.7 Test Viewpoints
- Verify that `getUnitPrice` returns `unitPrice`.

### 3.6 isDiscountable
#### 3.6.1 Inputs/Outputs
- Signature: `isDiscountable()`

#### 3.6.2 Preconditions
- None

#### 3.6.3 Postconditions
- Returns `isDiscountable` directly.

#### 3.6.4 Normal Flow
- `isDiscountable` returns `isDiscountable`.

#### 3.6.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.6.6 Dependencies
- None

#### 3.6.7 Test Viewpoints
- Verify that `isDiscountable` returns `isDiscountable`.

### 3.7 isTaxable
#### 3.7.1 Inputs/Outputs
- Signature: `isTaxable()`

#### 3.7.2 Preconditions
- None

#### 3.7.3 Postconditions
- Returns `isTaxable` directly.

#### 3.7.4 Normal Flow
- `isTaxable` returns `isTaxable`.

#### 3.7.5 Error/Boundary Handling
- No explicit exception throw or boundary-only branch is observed in source.

#### 3.7.6 Dependencies
- None

#### 3.7.7 Test Viewpoints
- Verify that `isTaxable` returns `isTaxable`.

## 4. Cautions
- None

## 5. Recommendations (Optional)
- None

## 6. Open Questions (Insufficient Analysis)
- None