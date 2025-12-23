package com.example.legacy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerService_getCustomerCountSimplifiedTest {

    @Test
    void shouldReturnZeroWhenNoCustomersAdded() {
        var customerService = new CustomerService();
        int count = customerService.getCustomerCount();
        assertEquals(0, count);
    }

    @Test
    void shouldReturnOneWhenOneCustomerAdded() {
        var customerService = new CustomerService();
        var customer = new CustomerService.Customer("1", "John Doe");
        customerService.addCustomer(customer);
        int count = customerService.getCustomerCount();
        assertEquals(1, count);
    }

    @Test
    void shouldReturnCorrectCountForMultipleCustomers() {
        var customerService = new CustomerService();
        var customer1 = new CustomerService.Customer("1", "John Doe");
        var customer2 = new CustomerService.Customer("2", "Jane Doe");
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        int count = customerService.getCustomerCount();
        assertEquals(2, count);
    }

    @Test
    void shouldReturnZeroAfterClearingAllCustomers() {
        var customerService = new CustomerService();
        var customer = new CustomerService.Customer("1", "John Doe");
        customerService.addCustomer(customer);
        customerService.clearAllCustomers();
        int count = customerService.getCustomerCount();
        assertEquals(0, count);
    }
}