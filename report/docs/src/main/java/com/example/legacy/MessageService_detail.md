# MessageService Detailed Design

## 1. Purpose and Responsibilities (Facts)
The `MessageService` class is responsible for formatting messages by combining a prefix and a body. It ensures that the body is not empty and applies transformations to the prefix and body as needed.

## 2. External Class Specification
- Class Name: `MessageService`
- Package: `com.example.legacy`
- File Path: `src/main/java/com/example/legacy/MessageService.java`
- Class Type: Class
- Extends: None
- Implements: None
- Class Attributes:
  - nested_class: false
  - anonymous_class: false
  - has_nested_classes: false
  - enclosing_type: none
- Fields:
  - No fields

## 3. Method Specifications

### 3.1 formatMessage
#### 3.1.1 Inputs/Outputs
- **Inputs**:
  - `String prefix`
  - `String body`
- **Outputs**:
  - `String` (formatted message)

#### 3.1.2 Preconditions
- `body` must not be empty (checked by `StringUtil.isEmpty(body)`).

#### 3.1.3 Postconditions
- Returns a formatted string combining the prefix and body, with transformations applied.

#### 3.1.4 Normal Flow
1. Check if `body` is empty using `StringUtil.isEmpty(body)`.
2. If `body` is not empty:
   - Determine `cleanPrefix` by checking if `prefix` is empty. If empty, use "MSG"; otherwise, convert `prefix` to uppercase using `StringUtil.toUpperCase(prefix)`.
   - Truncate `body` to 100 characters using `StringUtil.truncate(body, 100)`.
   - Concatenate `cleanPrefix` and `truncatedBody` with a colon separator and return the result.

#### 3.1.5 Error/Boundary Handling
- If `body` is empty, return an empty string immediately.

#### 3.1.6 Dependencies
- `com.example.legacy.util.StringUtil#toUpperCase(java.lang.String)`
- `com.example.legacy.util.StringUtil#isEmpty(java.lang.String)`
- `com.example.legacy.util.StringUtil#truncate(java.lang.String, int)`

#### 3.1.7 Test Viewpoints
- Verify that an empty `body` results in an empty string.
- Test with an empty `prefix` to ensure "MSG" is used.
- Test with a non-empty `prefix` to ensure it is converted to uppercase.
- Ensure `body` is truncated to 100 characters if longer.
- Validate the concatenation format of the result.

## 4. Cautions
- None

## 5. Recommendations (Optional)
- None

## 6. Open Questions (Insufficient Analysis)
- None