package com.example.legacy.service;

/**
 * Sample service class with constructor injection (DI pattern).
 * Used to test DIHarnessGenerator functionality.
 */
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    /**
     * Process an order by ID.
     * 
     * @param orderId the order ID
     * @return true if processing succeeded
     */
    public boolean processOrder(String orderId) {
        if (orderId == null || orderId.isBlank()) {
            return false;
        }

        var order = orderRepository.findById(orderId);
        if (order == null) {
            return false;
        }

        // Process the order
        order.setStatus("PROCESSING");
        orderRepository.save(order);

        // Send notification
        notificationService.sendNotification(orderId, "Order is being processed");

        return true;
    }

    /**
     * Cancel an order by ID.
     * 
     * @param orderId the order ID
     * @return true if cancellation succeeded
     */
    public boolean cancelOrder(String orderId) {
        if (orderId == null) {
            return false;
        }

        var order = orderRepository.findById(orderId);
        if (order == null) {
            return false;
        }

        order.setStatus("CANCELLED");
        orderRepository.save(order);
        notificationService.sendNotification(orderId, "Order has been cancelled");

        return true;
    }
}
