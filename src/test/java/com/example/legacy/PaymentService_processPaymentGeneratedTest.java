package com.example.legacy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentService_processPaymentGeneratedTest {

    @Test
    void shouldFail_whenOrderIdIsNull() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);
        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment(null, BigDecimal.TEN, "customerId", "CREDIT_CARD");

        // assert
        assertFalse(result.success);
        assertEquals("Order ID is required", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }

    @Test
    void shouldFail_whenAmountIsNegative() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);
        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("orderId", BigDecimal.valueOf(-1), "customerId", "CREDIT_CARD");

        // assert
        assertFalse(result.success);
        assertEquals("Amount must be positive", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }

    @Test
    void shouldFail_whenCustomerIdIsBlank() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);
        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("orderId", BigDecimal.TEN, " ", "CREDIT_CARD");

        // assert
        assertFalse(result.success);
        assertEquals("Customer ID is required", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }

    @Test
    void shouldFail_whenPaymentMethodIsInvalid() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);
        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("orderId", BigDecimal.TEN, "customerId", "INVALID_METHOD");

        // assert
        assertFalse(result.success);
        assertEquals("Invalid payment method: INVALID_METHOD", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }

    @Test
    void shouldFail_whenPaymentAlreadyProcessed() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);
        var existingPayment = new PaymentService.Payment("txnId", "orderId", "customerId", BigDecimal.TEN, "CREDIT_CARD", "COMPLETED", LocalDateTime.now());
        when(paymentRepository.findByOrderId("orderId")).thenReturn(Optional.of(existingPayment));
        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("orderId", BigDecimal.TEN, "customerId", "CREDIT_CARD");

        // assert
        assertFalse(result.success);
        assertEquals("Payment already processed for order: orderId", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService);
    }

    @Test
    void shouldSucceed_whenPaymentIsProcessedSuccessfully() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);
        var gatewayResponse = PaymentService.GatewayResponse.success("txnId");
        when(paymentGateway.charge("customerId", BigDecimal.TEN, "CREDIT_CARD")).thenReturn(gatewayResponse);
        when(paymentRepository.findByOrderId("orderId")).thenReturn(Optional.empty());
        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.processPayment("orderId", BigDecimal.TEN, "customerId", "CREDIT_CARD");

        // assert
        assertTrue(result.success);
        assertEquals("txnId", result.transactionId);
        verify(paymentRepository).save(any(PaymentService.Payment.class));
        verify(notificationService).sendPaymentConfirmation("customerId", "orderId", BigDecimal.TEN);
    }
}