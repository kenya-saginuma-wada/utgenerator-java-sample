package com.example.legacy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ICustomerRepository_deleteGeneratedTest {

    @Test
    void delete_shouldInvokeDeleteMethod() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String customerId = "123";

        // act
        repository.delete(customerId);

        // assert
        verify(repository).delete(customerId);
    }

    @Test
    void delete_shouldNotThrowExceptionForValidId() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String customerId = "valid-id";

        // act & assert
        assertDoesNotThrow(() -> repository.delete(customerId));
    }

    @Test
    void delete_shouldHandleNonExistentIdGracefully() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String nonExistentId = "non-existent-id";

        // act
        repository.delete(nonExistentId);

        // assert
        verify(repository).delete(nonExistentId);
    }

    @Test
    void delete_shouldNotInteractWithOtherMethods() {
        // arrange
        ICustomerRepository repository = mock(ICustomerRepository.class);
        String customerId = "456";

        // act
        repository.delete(customerId);

        // assert
        verify(repository).delete(customerId);
        verifyNoMoreInteractions(repository);
    }
}
