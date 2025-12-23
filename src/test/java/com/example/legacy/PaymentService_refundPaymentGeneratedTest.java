package com.example.legacy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentService_refundPaymentGeneratedTest {

    @Test
    void shouldFail_whenTransactionIdIsNull() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.refundPayment(null, BigDecimal.TEN);

        // assert
        assertNotNull(result);
        assertFalse(result.success);
        assertEquals("Transaction ID is required", result.errorMessage);
        verifyNoInteractions(paymentGateway, notificationService, paymentRepository);
    }

    @Test
    void shouldFail_whenPaymentNotFound() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        when(paymentRepository.findByTransactionId("txn123")).thenReturn(Optional.empty());

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.refundPayment("txn123", BigDecimal.TEN);

        // assert
        assertNotNull(result);
        assertFalse(result.success);
        assertEquals("Payment not found: txn123", result.errorMessage);
        verify(paymentRepository).findByTransactionId("txn123");
        verifyNoInteractions(paymentGateway, notificationService);
    }

    @Test
    void shouldFail_whenRefundAmountExceedsOriginal() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var payment = new PaymentService.Payment("txn123", "order123", "cust123", BigDecimal.TEN, "CREDIT_CARD", "COMPLETED", LocalDateTime.now());
        when(paymentRepository.findByTransactionId("txn123")).thenReturn(Optional.of(payment));

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.refundPayment("txn123", BigDecimal.valueOf(20));

        // assert
        assertNotNull(result);
        assertFalse(result.success);
        assertEquals("Refund amount exceeds original payment", result.errorMessage);
        verify(paymentRepository).findByTransactionId("txn123");
        verifyNoInteractions(paymentGateway, notificationService);
    }

    @Test
    void shouldFail_whenRefundFailsAtGateway() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var payment = new PaymentService.Payment("txn123", "order123", "cust123", BigDecimal.TEN, "CREDIT_CARD", "COMPLETED", LocalDateTime.now());
        when(paymentRepository.findByTransactionId("txn123")).thenReturn(Optional.of(payment));

        var refundResponse = PaymentService.GatewayResponse.failure("Gateway error");
        when(paymentGateway.refund("txn123", BigDecimal.TEN)).thenReturn(refundResponse);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.refundPayment("txn123", BigDecimal.TEN);

        // assert
        assertNotNull(result);
        assertFalse(result.success);
        assertEquals("Refund failed: Gateway error", result.errorMessage);
        verify(paymentRepository).findByTransactionId("txn123");
        verify(paymentGateway).refund("txn123", BigDecimal.TEN);
        verifyNoInteractions(notificationService);
    }

    @Test
    void shouldSucceed_whenRefundIsProcessedSuccessfully() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        var payment = new PaymentService.Payment("txn123", "order123", "cust123", BigDecimal.TEN, "CREDIT_CARD", "COMPLETED", LocalDateTime.now());
        when(paymentRepository.findByTransactionId("txn123")).thenReturn(Optional.of(payment));

        var refundResponse = PaymentService.GatewayResponse.success("refundTxn123");
        when(paymentGateway.refund("txn123", BigDecimal.TEN)).thenReturn(refundResponse);

        var service = new PaymentService(paymentGateway, notificationService, paymentRepository);

        // act
        var result = service.refundPayment("txn123", BigDecimal.TEN);

        // assert
        assertNotNull(result);
        assertTrue(result.success);
        assertEquals("refundTxn123", result.refundTransactionId);
        assertEquals(BigDecimal.TEN, result.refundAmount);
        verify(paymentRepository).findByTransactionId("txn123");
        verify(paymentGateway).refund("txn123", BigDecimal.TEN);
        verify(paymentRepository).save(payment);
        verify(notificationService).sendRefundConfirmation("cust123", "order123", BigDecimal.TEN);
    }
}