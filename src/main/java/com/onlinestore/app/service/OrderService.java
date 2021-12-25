package com.onlinestore.app.service;

import com.onlinestore.app.model.Order;

import java.util.List;

/**
 * The interface Order service.
 */
public interface OrderService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Order> findAll();

    /**
     * Find by id order.
     *
     * @param id the id
     * @return the order
     */
    Order findById(Long id);

    /**
     * Save order.
     *
     * @param order the order
     * @return the order
     */
    Order save(Order order);

    /**
     * Update order.
     *
     * @param order the order
     * @return the order
     */
    Order update(Order order);

    /**
     * Delete.
     *
     * @param order the order
     */
    void delete(Order order);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
