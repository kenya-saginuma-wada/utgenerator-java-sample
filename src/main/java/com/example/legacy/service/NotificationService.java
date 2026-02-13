package com.example.legacy.service;

/**
 * Notification service interface for DI testing.
 */
public interface NotificationService {
    void sendNotification(String orderId, String message);
}
