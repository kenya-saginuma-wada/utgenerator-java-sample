package com.example.legacy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCustomerData__init_GeneratedTest {

    @Test
    void shouldInitializeWithGivenValues() {
        // arrange
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";

        // act
        SimpleCustomerData customerData = new SimpleCustomerData(firstName, lastName, email);

        // assert
        assertEquals(firstName, customerData.getFirstName());
        assertEquals(lastName, customerData.getLastName());
        assertEquals(email, customerData.getEmail());
    }

    @Test
    void shouldInitializeWithEmptyValues() {
        // arrange
        String firstName = "";
        String lastName = "";
        String email = "";

        // act
        SimpleCustomerData customerData = new SimpleCustomerData(firstName, lastName, email);

        // assert
        assertEquals(firstName, customerData.getFirstName());
        assertEquals(lastName, customerData.getLastName());
        assertEquals(email, customerData.getEmail());
    }

    @Test
    void shouldInitializeWithNullValues() {
        // arrange
        String firstName = null;
        String lastName = null;
        String email = null;

        // act
        SimpleCustomerData customerData = new SimpleCustomerData(firstName, lastName, email);

        // assert
        assertNull(customerData.getFirstName());
        assertNull(customerData.getLastName());
        assertNull(customerData.getEmail());
    }

    @Test
    void shouldInitializeWithMixedValues() {
        // arrange
        String firstName = "Jane";
        String lastName = null;
        String email = "jane.doe@example.com";

        // act
        SimpleCustomerData customerData = new SimpleCustomerData(firstName, lastName, email);

        // assert
        assertEquals(firstName, customerData.getFirstName());
        assertNull(customerData.getLastName());
        assertEquals(email, customerData.getEmail());
    }
}
