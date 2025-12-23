package com.example.legacy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentService__init_GeneratedTest {

    @Test
    void shouldInitializePaymentServiceWithValidDependencies() {
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
    void shouldNotThrowExceptionWhenPaymentGatewayIsNull() {
        // arrange
        PaymentService.PaymentGateway paymentGateway = null;
        var notificationService = mock(PaymentService.NotificationService.class);
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        // act & assert
        assertDoesNotThrow(() -> 
            new PaymentService(paymentGateway, notificationService, paymentRepository)
        );
    }

    @Test
    void shouldNotThrowExceptionWhenNotificationServiceIsNull() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        PaymentService.NotificationService notificationService = null;
        var paymentRepository = mock(PaymentService.PaymentRepository.class);

        // act & assert
        assertDoesNotThrow(() -> 
            new PaymentService(paymentGateway, notificationService, paymentRepository)
        );
    }

    @Test
    void shouldNotThrowExceptionWhenPaymentRepositoryIsNull() {
        // arrange
        var paymentGateway = mock(PaymentService.PaymentGateway.class);
        var notificationService = mock(PaymentService.NotificationService.class);
        PaymentService.PaymentRepository paymentRepository = null;

        // act & assert
        assertDoesNotThrow(() -> 
            new PaymentService(paymentGateway, notificationService, paymentRepository)
        );
    }
}