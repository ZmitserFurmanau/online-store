package com.onlinestore.app.repository;

import com.onlinestore.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name customer.
     *
     * @param name the name
     * @return the customer
     */
    Customer findByName(String name);
}
