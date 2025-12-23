package com.example.legacy;

import com.example.legacy.CustomerService.Customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerService_Customer_getIdGeneratedTest {

    @Test
    void shouldReturnId_whenIdIsSet() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");
        
        // act
        var result = customer.getId();
        
        // assert
        assertEquals("123", result);
    }

    @Test
    void shouldReturnUpdatedId_whenIdIsChanged() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");
        customer.setId("456");
        
        // act
        var result = customer.getId();
        
        // assert
        assertEquals("456", result);
    }

    @Test
    void shouldReturnNull_whenIdIsSetToNull() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");
        customer.setId(null);
        
        // act
        var result = customer.getId();
        
        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnEmptyString_whenIdIsSetToEmptyString() {
        // arrange
        var customer = new CustomerService.Customer("123", "John Doe");
        customer.setId("");
        
        // act
        var result = customer.getId();
        
        // assert
        assertEquals("", result);
    }
}
