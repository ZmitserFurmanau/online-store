package com.onlinestore.app.repository;

import com.onlinestore.app.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Stock repository.
 */
public interface StockRepository extends JpaRepository<Stock, Long> {

    /**
     * Exists by quantity boolean.
     *
     * @param quantity the quantity
     * @return the boolean
     */
    boolean existsByQuantity(Integer quantity);

    /**
     * Find by quantity stock.
     *
     * @param quantity the quantity
     * @return the stock
     */
    Stock findByQuantity(Integer quantity);
}
