package com.example.legacy;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentService_PaymentServiceGeneratedTest {

    @Test
    void shouldInitializePaymentService_withValidDependencies() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        // act
        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // assert
        assertNotNull(service);
    }

    @Test
    void shouldProcessPaymentSuccessfully_whenValidInputsProvided() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        when(paymentGateway.charge(anyString(), any(BigDecimal.class), anyString()))
                .thenReturn(PaymentService.GatewayResponse.success("txn123"));

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("order123", BigDecimal.TEN, "customer123", "CREDIT_CARD");

        // assert
        assertTrue(result.success);
        assertEquals("txn123", result.transactionId);
        verify(paymentRepository).save(any(PaymentService.Payment.class));
        verify(notificationService).sendPaymentConfirmation("customer123", "order123", BigDecimal.TEN);
    }

    @Test
    void shouldFailProcessPayment_whenOrderIdIsNull() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment(null, BigDecimal.TEN, "customer123", "CREDIT_CARD");

        // assert
        assertFalse(result.success);
        assertEquals("Order ID is required", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }

    @Test
    void shouldFailProcessPayment_whenAmountIsNegative() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("order123", BigDecimal.valueOf(-1), "customer123", "CREDIT_CARD");

        // assert
        assertFalse(result.success);
        assertEquals("Amount must be positive", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }

    @Test
    void shouldFailProcessPayment_whenPaymentMethodIsInvalid() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("order123", BigDecimal.TEN, "customer123", "INVALID_METHOD");

        // assert
        assertFalse(result.success);
        assertEquals("Invalid payment method: INVALID_METHOD", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }
}
