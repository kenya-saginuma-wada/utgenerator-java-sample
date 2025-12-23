package com.example.legacy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ICustomerRepository_saveGeneratedTest {

    @Test
    void save_shouldReturnSavedCustomer() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        when(repository.save(customer)).thenReturn(customer);

        // act
        SimpleCustomerData result = repository.save(customer);

        // assert
        assertEquals(customer, result);
    }

    @Test
    void save_shouldNotReturnNull() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        SimpleCustomerData customer = mock(SimpleCustomerData.class);
        when(repository.save(customer)).thenReturn(customer);

        // act
        SimpleCustomerData result = repository.save(customer);

        // assert
        assertNotNull(result);
    }

    @Test
    void save_shouldInvokeSaveMethod() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        SimpleCustomerData customer = mock(SimpleCustomerData.class);

        // act
        repository.save(customer);

        // assert
        verify(repository).save(customer);
    }

    @Test
    void save_shouldHandleNullCustomer() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        SimpleCustomerData customer = null;
        when(repository.save(customer)).thenThrow(IllegalArgumentException.class);

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> repository.save(customer));
    }
}
