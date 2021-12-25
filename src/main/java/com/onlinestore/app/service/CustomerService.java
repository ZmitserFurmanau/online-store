package com.onlinestore.app.service;

import com.onlinestore.app.model.Customer;

import java.util.List;

/**
 * The interface Customer service.
 */
public interface CustomerService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Customer> findAll();

    /**
     * Find by id customer.
     *
     * @param id the id
     * @return the customer
     */
    Customer findById(Long id);

    /**
     * Save customer.
     *
     * @param customer the customer
     * @return the customer
     */
    Customer save(Customer customer);

    /**
     * Update customer.
     *
     * @param customer the customer
     * @return the customer
     */
    Customer update(Customer customer);

    /**
     * Delete.
     *
     * @param customer the customer
     */
    void delete(Customer customer);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
