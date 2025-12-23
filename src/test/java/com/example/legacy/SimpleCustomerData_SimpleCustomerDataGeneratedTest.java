package com.example.legacy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;  // Import LocalDate

class SimpleCustomerData_SimpleCustomerDataGeneratedTest {

    @Test
    void shouldInitializeFieldsCorrectly_whenUsingParameterizedConstructor() {
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
    void shouldAllowModificationOfFirstName() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        String newFirstName = "Jane";

        // act
        customerData.setFirstName(newFirstName);

        // assert
        assertEquals(newFirstName, customerData.getFirstName());
    }

    @Test
    void shouldAllowModificationOfLastName() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        String newLastName = "Smith";

        // act
        customerData.setLastName(newLastName);

        // assert
        assertEquals(newLastName, customerData.getLastName());
    }

    @Test
    void shouldAllowModificationOfEmail() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        String newEmail = "jane.smith@example.com";

        // act
        customerData.setEmail(newEmail);

        // assert
        assertEquals(newEmail, customerData.getEmail());
    }

    @Test
    void shouldAllowSettingAndGettingParamDate() {
        // arrange
        SimpleCustomerData customerData = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        LocalDate date = LocalDate.of(2023, 10, 1);

        // act
        customerData.setParamDate(date);

        // assert
        assertEquals(date, customerData.getParamDate());
    }
}