package com.example.legacy;

import com.example.legacy.CustomerService.Customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerService_Customer_setIdGeneratedTest {

    @Test
    void shouldSetIdSuccessfully_whenValidIdProvided() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("initialId", "John Doe");

        // act
        customer.setId("newId");

        // assert
        assertEquals("newId", customer.getId());
    }

    @Test
    void shouldSetIdToEmpty_whenEmptyIdProvided() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("initialId", "John Doe");

        // act
        customer.setId("");

        // assert
        assertEquals("", customer.getId());
    }

    @Test
    void shouldSetIdToNull_whenNullIdProvided() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("initialId", "John Doe");

        // act
        customer.setId(null);

        // assert
        assertNull(customer.getId());
    }

    @Test
    void shouldSetIdSuccessfully_whenIdContainsSpecialCharacters() {
        // arrange
        CustomerService.Customer customer = new CustomerService.Customer("initialId", "John Doe");

        // act
        customer.setId("id@123!");

        // assert
        assertEquals("id@123!", customer.getId());
    }
}
