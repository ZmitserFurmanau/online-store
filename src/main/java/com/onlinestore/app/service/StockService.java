package com.onlinestore.app.service;

import com.onlinestore.app.model.Stock;

import java.util.List;

/**
 * The interface Stock service.
 */
public interface StockService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Stock> findAll();

    /**
     * Find by id stock.
     *
     * @param id the id
     * @return the stock
     */
    Stock findById(Long id);

    /**
     * Save stock.
     *
     * @param stock the stock
     * @return the stock
     */
    Stock save(Stock stock);

    /**
     * Update stock.
     *
     * @param stock the stock
     * @return the stock
     */
    Stock update(Stock stock);

    /**
     * Delete.
     *
     * @param stock the stock
     */
    void delete(Stock stock);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
