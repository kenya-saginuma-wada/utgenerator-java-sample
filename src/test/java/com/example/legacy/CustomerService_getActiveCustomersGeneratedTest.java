package com.example.legacy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

class CustomerService_getActiveCustomersGeneratedTest {

    @Test
    void shouldReturnEmptyListWhenNoCustomers() throws Exception {
        // arrange
        var customerService = new CustomerService();

        // act
        List<CustomerService.Customer> activeCustomers = customerService.getActiveCustomers();

        // assert
        assertNotNull(activeCustomers);
        assertTrue(activeCustomers.isEmpty());
    }

    @Test
    void shouldReturnActiveCustomersWithPositiveBalance() throws Exception {
        // arrange
        var customerService = new CustomerService();
        var customer1 = new CustomerService.Customer("1", "John Doe");
        customer1.setActive(true);
        customer1.setBalance(100.0);

        var customer2 = new CustomerService.Customer("2", "Jane Doe");
        customer2.setActive(true);
        customer2.setBalance(-50.0);

        setPrivateField(customerService, "customers", List.of(customer1, customer2));

        // act
        List<CustomerService.Customer> activeCustomers = customerService.getActiveCustomers();

        // assert
        assertNotNull(activeCustomers);
        assertEquals(1, activeCustomers.size());
        assertEquals("1", activeCustomers.get(0).getId());
    }

    @Test
    void shouldReturnActivePremiumCustomersWithNonPositiveBalance() throws Exception {
        // arrange
        var customerService = new CustomerService();
        var customer1 = new CustomerService.Customer("1", "John Doe");
        customer1.setActive(true);
        customer1.setBalance(0.0);
        customer1.setPremium(true);

        var customer2 = new CustomerService.Customer("2", "Jane Doe");
        customer2.setActive(true);
        customer2.setBalance(-50.0);
        customer2.setPremium(false);

        setPrivateField(customerService, "customers", List.of(customer1, customer2));

        // act
        List<CustomerService.Customer> activeCustomers = customerService.getActiveCustomers();

        // assert
        assertNotNull(activeCustomers);
        assertEquals(1, activeCustomers.size());
        assertEquals("1", activeCustomers.get(0).getId());
    }

    @Test
    void shouldReturnEmptyListWhenNoActiveCustomers() throws Exception {
        // arrange
        var customerService = new CustomerService();
        var customer1 = new CustomerService.Customer("1", "John Doe");
        customer1.setActive(false);
        customer1.setBalance(100.0);

        var customer2 = new CustomerService.Customer("2", "Jane Doe");
        customer2.setActive(false);
        customer2.setBalance(0.0);

        setPrivateField(customerService, "customers", List.of(customer1, customer2));

        // act
        List<CustomerService.Customer> activeCustomers = customerService.getActiveCustomers();

        // assert
        assertNotNull(activeCustomers);
        assertTrue(activeCustomers.isEmpty());
    }

    private void setPrivateField(Object target, String name, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }
}
