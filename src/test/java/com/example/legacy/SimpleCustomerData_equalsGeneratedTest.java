package com.example.legacy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCustomerData_equalsGeneratedTest {

    @Test
    void shouldReturnTrue_whenSameObject() {
        // arrange
        SimpleCustomerData customer = new SimpleCustomerData("John", "Doe", "john.doe@example.com");

        // act
        boolean result = customer.equals(customer);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalse_whenNullObject() {
        // arrange
        SimpleCustomerData customer = new SimpleCustomerData("John", "Doe", "john.doe@example.com");

        // act
        boolean result = customer.equals(null);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalse_whenDifferentClass() {
        // arrange
        SimpleCustomerData customer = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        Object other = new Object();

        // act
        boolean result = customer.equals(other);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnTrue_whenEqualObjects() {
        // arrange
        SimpleCustomerData customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        SimpleCustomerData customer2 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");

        // act
        boolean result = customer1.equals(customer2);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalse_whenDifferentFirstName() {
        // arrange
        SimpleCustomerData customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        SimpleCustomerData customer2 = new SimpleCustomerData("Jane", "Doe", "john.doe@example.com");

        // act
        boolean result = customer1.equals(customer2);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalse_whenDifferentLastName() {
        // arrange
        SimpleCustomerData customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        SimpleCustomerData customer2 = new SimpleCustomerData("John", "Smith", "john.doe@example.com");

        // act
        boolean result = customer1.equals(customer2);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalse_whenDifferentEmail() {
        // arrange
        SimpleCustomerData customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        SimpleCustomerData customer2 = new SimpleCustomerData("John", "Doe", "jane.doe@example.com");

        // act
        boolean result = customer1.equals(customer2);

        // assert
        assertFalse(result);
    }
}
