package com.example.legacy;

import com.example.legacy.CustomerService.Customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerService_Customer_getNameGeneratedTest {

    @Test
    void shouldReturnName_whenNameIsSetInConstructor() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");

        // act
        var result = customer.getName();

        // assert
        assertEquals("John Doe", result);
    }

    @Test
    void shouldReturnUpdatedName_whenNameIsChanged() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");
        customer.setName("Jane Doe");

        // act
        var result = customer.getName();

        // assert
        assertEquals("Jane Doe", result);
    }

    @Test
    void shouldReturnEmptyString_whenNameIsSetToEmpty() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");
        customer.setName("");

        // act
        var result = customer.getName();

        // assert
        assertEquals("", result);
    }

    @Test
    void shouldReturnNull_whenNameIsSetToNull() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");
        customer.setName(null);

        // act
        var result = customer.getName();

        // assert
        assertNull(result);
    }
}
