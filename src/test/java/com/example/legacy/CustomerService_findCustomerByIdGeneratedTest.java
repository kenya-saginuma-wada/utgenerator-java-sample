package com.example.legacy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.lang.reflect.Field;

class CustomerService_findCustomerByIdGeneratedTest {

    @Test
    void shouldReturnNullWhenIdIsNull() {
        // arrange
        CustomerService service = new CustomerService();

        // act
        CustomerService.Customer result = service.findCustomerById(null);

        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenIdIsEmpty() {
        // arrange
        CustomerService service = new CustomerService();

        // act
        CustomerService.Customer result = service.findCustomerById("");

        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenCustomerNotFound() throws Exception {
        // arrange
        CustomerService service = new CustomerService();
        CustomerService.Customer customer = new CustomerService.Customer("123", "John Doe");
        setPrivateField(service, "customers", List.of(customer));

        // act
        CustomerService.Customer result = service.findCustomerById("999");

        // assert
        assertNull(result);
    }

    @Test
    void shouldReturnCustomerWhenIdMatches() throws Exception {
        // arrange
        CustomerService service = new CustomerService();
        CustomerService.Customer customer = new CustomerService.Customer("123", "John Doe");
        setPrivateField(service, "customers", List.of(customer));

        // act
        CustomerService.Customer result = service.findCustomerById("123");

        // assert
        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals("John Doe", result.getName());
    }

    @Test
    void shouldReturnFirstMatchingCustomerWhenMultipleExist() throws Exception {
        // arrange
        CustomerService service = new CustomerService();
        CustomerService.Customer customer1 = new CustomerService.Customer("123", "John Doe");
        CustomerService.Customer customer2 = new CustomerService.Customer("456", "Jane Doe");
        setPrivateField(service, "customers", List.of(customer1, customer2));

        // act
        CustomerService.Customer result = service.findCustomerById("123");

        // assert
        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals("John Doe", result.getName());
    }

    private void setPrivateField(Object target, String name, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }
}