package com.onlinestore.app.repository;

import com.onlinestore.app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Exists by date boolean.
     *
     * @param date the date
     * @return the boolean
     */
    boolean existsByDate(LocalDateTime date);

    /**
     * Find by date order.
     *
     * @param date the date
     * @return the order
     */
    Order findByDate(LocalDateTime date);
}
