package com.example.legacy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCustomerData_hashCodeGeneratedTest {

    @Test
    void hashCode_shouldReturnSameValueForEqualObjects() {
        // arrange
        var customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        var customer2 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");

        // act
        int hashCode1 = customer1.hashCode();
        int hashCode2 = customer2.hashCode();

        // assert
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void hashCode_shouldReturnDifferentValueForDifferentFirstName() {
        // arrange
        var customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        var customer2 = new SimpleCustomerData("Jane", "Doe", "john.doe@example.com");

        // act
        int hashCode1 = customer1.hashCode();
        int hashCode2 = customer2.hashCode();

        // assert
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void hashCode_shouldReturnDifferentValueForDifferentLastName() {
        // arrange
        var customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        var customer2 = new SimpleCustomerData("John", "Smith", "john.doe@example.com");

        // act
        int hashCode1 = customer1.hashCode();
        int hashCode2 = customer2.hashCode();

        // assert
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void hashCode_shouldReturnDifferentValueForDifferentEmail() {
        // arrange
        var customer1 = new SimpleCustomerData("John", "Doe", "john.doe@example.com");
        var customer2 = new SimpleCustomerData("John", "Doe", "jane.doe@example.com");

        // act
        int hashCode1 = customer1.hashCode();
        int hashCode2 = customer2.hashCode();

        // assert
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void hashCode_shouldReturnConsistentValueForSameObject() {
        // arrange
        var customer = new SimpleCustomerData("John", "Doe", "john.doe@example.com");

        // act
        int hashCode1 = customer.hashCode();
        int hashCode2 = customer.hashCode();

        // assert
        assertEquals(hashCode1, hashCode2);
    }
}
