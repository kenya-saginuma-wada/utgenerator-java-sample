package com.example.legacy;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Service using OSS libraries (Guava)
 */
public class OrderProcessingService {

    private final List<String> supportedCurrencies = ImmutableList.of("USD", "EUR", "JPY");

    public void processOrder(String orderId, double amount, String currency) {
        // Using Guava Preconditions
        Preconditions.checkNotNull(orderId, "Order ID cannot be null");
        Preconditions.checkArgument(!orderId.isEmpty(), "Order ID cannot be empty");
        Preconditions.checkArgument(amount > 0, "Amount must be positive: %s", amount);
        Preconditions.checkNotNull(currency, "Currency cannot be null");
        Preconditions.checkArgument(supportedCurrencies.contains(currency), "Unsupported currency: %s", currency);

        System.out.println("Processing order " + orderId + " for " + amount + " " + currency);
    }

    public List<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }
}
