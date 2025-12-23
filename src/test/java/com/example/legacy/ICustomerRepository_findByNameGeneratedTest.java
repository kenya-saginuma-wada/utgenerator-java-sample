package com.example.legacy;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ICustomerRepository_findByNameGeneratedTest {

    @Test
    void findByName_shouldReturnEmptyList_whenNoCustomerMatches() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String namePattern = "NonExistentName";
        when(repository.findByName(namePattern)).thenReturn(List.of());

        // act
        List<SimpleCustomerData> result = repository.findByName(namePattern);

        // assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(repository).findByName(namePattern);
    }

    @Test
    void findByName_shouldReturnListWithOneCustomer_whenOneCustomerMatches() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String namePattern = "John Doe";
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        when(repository.findByName(namePattern)).thenReturn(List.of(customer));

        // act
        List<SimpleCustomerData> result = repository.findByName(namePattern);

        // assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(customer, result.get(0));
        verify(repository).findByName(namePattern);
    }

    @Test
    void findByName_shouldReturnListWithMultipleCustomers_whenMultipleCustomersMatch() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String namePattern = "Jane";
        SimpleCustomerData customer1 = mock(SimpleCustomerData.class);
        SimpleCustomerData customer2 = mock(SimpleCustomerData.class);
        when(repository.findByName(namePattern)).thenReturn(List.of(customer1, customer2));

        // act
        List<SimpleCustomerData> result = repository.findByName(namePattern);

        // assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(customer1));
        assertTrue(result.contains(customer2));
        verify(repository).findByName(namePattern);
    }

    @Test
    void findByName_shouldHandleNullNamePatternGracefully() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String namePattern = null;
        when(repository.findByName(namePattern)).thenReturn(List.of());

        // act
        List<SimpleCustomerData> result = repository.findByName(namePattern);

        // assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(repository).findByName(namePattern);
    }
}
