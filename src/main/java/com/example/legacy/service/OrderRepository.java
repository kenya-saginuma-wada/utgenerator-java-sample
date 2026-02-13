package com.example.legacy.service;

/**
 * Order repository interface for DI testing.
 */
public interface OrderRepository {
    Order findById(String id);

    void save(Order order);
}
