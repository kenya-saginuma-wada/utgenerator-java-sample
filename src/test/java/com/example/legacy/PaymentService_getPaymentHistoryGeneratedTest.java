package com.example.legacy;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentService_getPaymentHistoryGeneratedTest {

    @Test
    void shouldThrow_whenCustomerIdIsNull() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> service.getPaymentHistory(null));
    }

    @Test
    void shouldThrow_whenCustomerIdIsBlank() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> service.getPaymentHistory(" "));
    }

    @Test
    void shouldReturnPaymentHistory_whenCustomerIdIsValid() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);
        var expectedPayments = List.of(mock(PaymentService.Payment.class));
        when(paymentRepository.findByCustomerId("validCustomerId")).thenReturn(expectedPayments);

        // act
        var result = service.getPaymentHistory("validCustomerId");

        // assert
        assertNotNull(result);
        assertEquals(expectedPayments, result);
        verify(paymentRepository).findByCustomerId("validCustomerId");
    }

    @Test
    void shouldReturnEmptyList_whenNoPaymentsFound() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);
        when(paymentRepository.findByCustomerId("noPaymentsCustomerId")).thenReturn(List.of());

        // act
        var result = service.getPaymentHistory("noPaymentsCustomerId");

        // assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(paymentRepository).findByCustomerId("noPaymentsCustomerId");
    }
}
