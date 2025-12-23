package com.example.legacy;

import com.example.legacy.CustomerService.Customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerService_Customer_CustomerGeneratedTest {

    @Test
    void shouldInitializeWithGivenIdAndName() {
        // arrange
        String expectedId = "123";
        String expectedName = "John Doe";

        // act
        CustomerService.Customer customer = new CustomerService.Customer(expectedId, expectedName);

        // assert
        assertEquals(expectedId, customer.getId());
        assertEquals(expectedName, customer.getName());
    }

    @Test
    void shouldBeActiveByDefault() {
        // arrange
        String id = "123";
        String name = "John Doe";

        // act
        CustomerService.Customer customer = new CustomerService.Customer(id, name);

        // assert
        assertTrue(customer.isActive());
    }

    @Test
    void shouldHaveZeroBalanceByDefault() {
        // arrange
        String id = "123";
        String name = "John Doe";

        // act
        CustomerService.Customer customer = new CustomerService.Customer(id, name);

        // assert
        assertEquals(0.0, customer.getBalance());
    }

    @Test
    void shouldNotBePremiumByDefault() {
        // arrange
        String id = "123";
        String name = "John Doe";

        // act
        CustomerService.Customer customer = new CustomerService.Customer(id, name);

        // assert
        assertFalse(customer.isPremium());
    }

    @Test
    void shouldAllowSettingAndGettingId() {
        // arrange
        String initialId = "123";
        String newId = "456";
        String name = "John Doe";
        CustomerService.Customer customer = new CustomerService.Customer(initialId, name);

        // act
        customer.setId(newId);

        // assert
        assertEquals(newId, customer.getId());
    }

    @Test
    void shouldAllowSettingAndGettingName() {
        // arrange
        String id = "123";
        String initialName = "John Doe";
        String newName = "Jane Doe";
        CustomerService.Customer customer = new CustomerService.Customer(id, initialName);

        // act
        customer.setName(newName);

        // assert
        assertEquals(newName, customer.getName());
    }
}
