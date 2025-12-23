package com.example.legacy;

import com.example.legacy.CustomerService.Customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerService_Customer_setNameGeneratedTest {

    @Test
    void shouldSetNameSuccessfully() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("123", "Old Name");

        // act
        customer.setName("New Name");

        // assert
        assertEquals("New Name", customer.getName());
    }

    @Test
    void shouldSetNameToEmptyString() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("123", "Old Name");

        // act
        customer.setName("");

        // assert
        assertEquals("", customer.getName());
    }

    @Test
    void shouldSetNameToNull() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("123", "Old Name");

        // act
        customer.setName(null);

        // assert
        assertNull(customer.getName());
    }

    @Test
    void shouldSetNameToSameValue() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("123", "Same Name");

        // act
        customer.setName("Same Name");

        // assert
        assertEquals("Same Name", customer.getName());
    }
}
