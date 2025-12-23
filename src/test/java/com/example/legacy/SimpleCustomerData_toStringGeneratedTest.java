package com.example.legacy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCustomerData_toStringGeneratedTest {

    @Test
    void toString_shouldReturnCorrectFormat_whenAllFieldsAreSet() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData("John", "Doe", "john.doe@example.com");

        // act
        String result = customerData.toString();

        // assert
        assertEquals("SimpleCustomerData{firstName='John', lastName='Doe', email='john.doe@example.com'}", result);
    }

    @Test
    void toString_shouldReturnCorrectFormat_whenFirstNameIsNull() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData(null, "Doe", "john.doe@example.com");

        // act
        String result = customerData.toString();

        // assert
        assertEquals("SimpleCustomerData{firstName='null', lastName='Doe', email='john.doe@example.com'}", result);
    }

    @Test
    void toString_shouldReturnCorrectFormat_whenLastNameIsNull() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData("John", null, "john.doe@example.com");

        // act
        String result = customerData.toString();

        // assert
        assertEquals("SimpleCustomerData{firstName='John', lastName='null', email='john.doe@example.com'}", result);
    }

    @Test
    void toString_shouldReturnCorrectFormat_whenEmailIsNull() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData("John", "Doe", null);

        // act
        String result = customerData.toString();

        // assert
        assertEquals("SimpleCustomerData{firstName='John', lastName='Doe', email='null'}", result);
    }

    @Test
    void toString_shouldReturnCorrectFormat_whenAllFieldsAreNull() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData(null, null, null);

        // act
        String result = customerData.toString();

        // assert
        assertEquals("SimpleCustomerData{firstName='null', lastName='null', email='null'}", result);
    }
}
