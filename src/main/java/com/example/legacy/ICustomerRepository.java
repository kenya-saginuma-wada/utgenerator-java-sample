package com.example.legacy;

import java.util.List;
import java.util.Optional;

/**
 * Interface only definition
 */
public interface ICustomerRepository {

    /**
     * Find customer by exact ID match
     * 
     * @param id Customer ID
     * @return Optional containing customer if found
     */
    Optional<SimpleCustomerData> findById(String id);

    /**
     * Find customers by name pattern
     * 
     * @param namePattern Name search pattern
     * @return List of matching customers
     */
    List<SimpleCustomerData> findByName(String namePattern);

    /**
     * Save customer data
     * 
     * @param customer Customer to save
     * @return Saved customer with updated fields (e.g. ID)
     */
    SimpleCustomerData save(SimpleCustomerData customer);

    /**
     * Delete customer by ID
     * 
     * @param id Customer ID to delete
     */
    void delete(String id);
}
