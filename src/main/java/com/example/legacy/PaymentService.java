package com.example.legacy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Payment processing service that depends on external components.
 * This class is designed to require mocking in unit tests.
 */
public class PaymentService {

    private final PaymentGateway paymentGateway;
    private final NotificationService notificationService;
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentGateway paymentGateway,
            NotificationService notificationService,
            PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.notificationService = notificationService;
        this.paymentRepository = paymentRepository;
    }

    /**
     * Process a payment for an order.
     * 
     * @param orderId       The order ID
     * @param amount        The payment amount
     * @param customerId    The customer ID
     * @param paymentMethod The payment method (CREDIT_CARD, DEBIT_CARD,
     *                      BANK_TRANSFER)
     * @return PaymentResult containing success status and transaction details
     */
    public PaymentResult processPayment(String orderId, BigDecimal amount,
            String customerId, String paymentMethod) {
        // Validate inputs
        if (orderId == null || orderId.isBlank()) {
            return PaymentResult.failure("Order ID is required");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return PaymentResult.failure("Amount must be positive");
        }
        if (customerId == null || customerId.isBlank()) {
            return PaymentResult.failure("Customer ID is required");
        }
        if (!isValidPaymentMethod(paymentMethod)) {
            return PaymentResult.failure("Invalid payment method: " + paymentMethod);
        }

        // Check for duplicate payment
        Optional<Payment> existingPayment = paymentRepository.findByOrderId(orderId);
        if (existingPayment.isPresent() && existingPayment.get().getStatus().equals("COMPLETED")) {
            return PaymentResult.failure("Payment already processed for order: " + orderId);
        }

        // Process payment through gateway
        GatewayResponse gatewayResponse = paymentGateway.charge(customerId, amount, paymentMethod);

        if (!gatewayResponse.isSuccess()) {
            return PaymentResult.failure("Payment gateway error: " + gatewayResponse.getErrorMessage());
        }

        // Save payment record
        Payment payment = new Payment(
                gatewayResponse.getTransactionId(),
                orderId,
                customerId,
                amount,
                paymentMethod,
                "COMPLETED",
                LocalDateTime.now());
        paymentRepository.save(payment);

        // Send notification
        notificationService.sendPaymentConfirmation(customerId, orderId, amount);

        return PaymentResult.success(gatewayResponse.getTransactionId(), amount);
    }

    /**
     * Refund a payment.
     * 
     * @param transactionId The original transaction ID
     * @param refundAmount  The amount to refund (null for full refund)
     * @return RefundResult containing success status
     */
    public RefundResult refundPayment(String transactionId, BigDecimal refundAmount) {
        if (transactionId == null || transactionId.isBlank()) {
            return RefundResult.failure("Transaction ID is required");
        }

        Optional<Payment> paymentOpt = paymentRepository.findByTransactionId(transactionId);
        if (paymentOpt.isEmpty()) {
            return RefundResult.failure("Payment not found: " + transactionId);
        }

        Payment payment = paymentOpt.get();
        BigDecimal actualRefundAmount = refundAmount != null ? refundAmount : payment.getAmount();

        if (actualRefundAmount.compareTo(payment.getAmount()) > 0) {
            return RefundResult.failure("Refund amount exceeds original payment");
        }

        GatewayResponse refundResponse = paymentGateway.refund(transactionId, actualRefundAmount);

        if (!refundResponse.isSuccess()) {
            return RefundResult.failure("Refund failed: " + refundResponse.getErrorMessage());
        }

        payment.setStatus("REFUNDED");
        paymentRepository.save(payment);

        notificationService.sendRefundConfirmation(payment.getCustomerId(), payment.getOrderId(), actualRefundAmount);

        return RefundResult.success(refundResponse.getTransactionId(), actualRefundAmount);
    }

    /**
     * Get payment history for a customer.
     */
    public List<Payment> getPaymentHistory(String customerId) {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID is required");
        }
        return paymentRepository.findByCustomerId(customerId);
    }

    private boolean isValidPaymentMethod(String method) {
        return method != null &&
                (method.equals("CREDIT_CARD") ||
                        method.equals("DEBIT_CARD") ||
                        method.equals("BANK_TRANSFER"));
    }

    // ========== Inner classes and interfaces ==========

    /**
     * Payment Gateway interface - external dependency to be mocked
     */
    public interface PaymentGateway {
        GatewayResponse charge(String customerId, BigDecimal amount, String paymentMethod);

        GatewayResponse refund(String transactionId, BigDecimal amount);
    }

    /**
     * Notification Service interface - external dependency to be mocked
     */
    public interface NotificationService {
        void sendPaymentConfirmation(String customerId, String orderId, BigDecimal amount);

        void sendRefundConfirmation(String customerId, String orderId, BigDecimal amount);
    }

    /**
     * Payment Repository interface - external dependency to be mocked
     */
    public interface PaymentRepository {
        Optional<Payment> findByOrderId(String orderId);

        Optional<Payment> findByTransactionId(String transactionId);

        List<Payment> findByCustomerId(String customerId);

        void save(Payment payment);
    }

    /**
     * Gateway response from payment processor
     */
    public static class GatewayResponse {
        private final boolean success;
        private final String transactionId;
        private final String errorMessage;

        private GatewayResponse(boolean success, String transactionId, String errorMessage) {
            this.success = success;
            this.transactionId = transactionId;
            this.errorMessage = errorMessage;
        }

        public static GatewayResponse success(String transactionId) {
            return new GatewayResponse(true, transactionId, null);
        }

        public static GatewayResponse failure(String errorMessage) {
            return new GatewayResponse(false, null, errorMessage);
        }

        public boolean isSuccess() {
            return success;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /**
     * Payment entity
     */
    public static class Payment {
        private final String transactionId;
        private final String orderId;
        private final String customerId;
        private final BigDecimal amount;
        private final String paymentMethod;
        private String status;
        private final LocalDateTime createdAt;

        public Payment(String transactionId, String orderId, String customerId,
                BigDecimal amount, String paymentMethod, String status, LocalDateTime createdAt) {
            this.transactionId = transactionId;
            this.orderId = orderId;
            this.customerId = customerId;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.status = status;
            this.createdAt = createdAt;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getOrderId() {
            return orderId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }

    /**
     * Payment processing result
     */
    public static class PaymentResult {
        public final boolean success;
        public final String transactionId;
        public final BigDecimal amount;
        public final String errorMessage;

        private PaymentResult(boolean success, String transactionId, BigDecimal amount, String errorMessage) {
            this.success = success;
            this.transactionId = transactionId;
            this.amount = amount;
            this.errorMessage = errorMessage;
        }

        public static PaymentResult success(String transactionId, BigDecimal amount) {
            return new PaymentResult(true, transactionId, amount, null);
        }

        public static PaymentResult failure(String errorMessage) {
            return new PaymentResult(false, null, null, errorMessage);
        }
    }

    /**
     * Refund processing result
     */
    public static class RefundResult {
        public final boolean success;
        public final String refundTransactionId;
        public final BigDecimal refundAmount;
        public final String errorMessage;

        private RefundResult(boolean success, String refundTransactionId, BigDecimal refundAmount,
                String errorMessage) {
            this.success = success;
            this.refundTransactionId = refundTransactionId;
            this.refundAmount = refundAmount;
            this.errorMessage = errorMessage;
        }

        public static RefundResult success(String refundTransactionId, BigDecimal refundAmount) {
            return new RefundResult(true, refundTransactionId, refundAmount, null);
        }

        public static RefundResult failure(String errorMessage) {
            return new RefundResult(false, null, null, errorMessage);
        }
    }
}
