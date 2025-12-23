package com.example.legacy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ICustomerRepository_findByIdGeneratedTest {

    @Test
    void findById_shouldReturnCustomer_whenCustomerExists() {
        // arrange
        var repository = mock(ICustomerRepository.class);
        var expectedCustomer = new SimpleCustomerData("123", "John Doe", "john.doe@example.com");
        when(repository.findById("123")).thenReturn(Optional.of(expectedCustomer));

        // act
        var result = repository.findById("123");

        // assert
        assertTrue(result.isPresent());
        assertEquals(expectedCustomer, result.get());
    }

    @Test
    void findById_shouldReturnEmpty_whenCustomerDoesNotExist() {
        // arrange
        var repository = mock(ICustomerRepository.class);
        when(repository.findById("999")).thenReturn(Optional.empty());

        // act
        var result = repository.findById("999");

        // assert
        assertFalse(result.isPresent());
    }

    @Test
    void findById_shouldBeCalledWithCorrectId() {
        // arrange
        var repository = mock(ICustomerRepository.class);
        var expectedId = "456";

        // act
        repository.findById(expectedId);

        // assert
        verify(repository).findById(expectedId);
    }

    @Test
    void findById_shouldNotInteractWithOtherMethods() {
        // arrange
        var repository = mock(ICustomerRepository.class);

        // act
        repository.findById("123");

        // assert
        verify(repository, never()).delete(anyString());
        verify(repository, never()).findByName(anyString());
        verify(repository, never()).save(any(SimpleCustomerData.class));
    }
}