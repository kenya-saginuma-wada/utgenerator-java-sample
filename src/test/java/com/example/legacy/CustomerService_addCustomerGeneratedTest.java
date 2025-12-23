package com.example.legacy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerService_addCustomerGeneratedTest {

    @Test
    void shouldThrowExceptionWhenCustomerIsNull() {
        // arrange
        var customerService = new CustomerService();

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> customerService.addCustomer(null));
    }

    @Test
    void shouldThrowExceptionWhenCustomerIdIsNull() {
        // arrange
        var customerService = new CustomerService();
        var customer = new CustomerService.Customer(null, "John Doe");

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> customerService.addCustomer(customer));
    }

    @Test
    void shouldThrowExceptionWhenCustomerIdIsEmpty() {
        // arrange
        var customerService = new CustomerService();
        var customer = new CustomerService.Customer("", "John Doe");

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> customerService.addCustomer(customer));
    }

    @Test
    void shouldAddCustomerSuccessfully() throws Exception {
        // arrange
        var customerService = new CustomerService();
        var customer = new CustomerService.Customer("123", "John Doe");

        // act
        customerService.addCustomer(customer);

        // assert
        assertEquals(1, customerService.getCustomerCount());
    }

    @Test
    void shouldNotAddCustomerWhenExceptionThrown() {
        // arrange
        var customerService = new CustomerService();
        var customer = new CustomerService.Customer("", "John Doe");

        // act
        try {
            customerService.addCustomer(customer);
        } catch (IllegalArgumentException e) {
            // expected exception
            // handle exception by logging or other means if necessary
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        // assert
        assertEquals(0, customerService.getCustomerCount());
    }
}
