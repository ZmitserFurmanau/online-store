package com.onlinestore.app.service;

import com.onlinestore.app.model.Seller;

import java.util.List;

/**
 * The interface Seller service.
 */
public interface SellerService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Seller> findAll();

    /**
     * Find by id seller.
     *
     * @param id the id
     * @return the seller
     */
    Seller findById(Long id);

    /**
     * Save seller.
     *
     * @param seller the seller
     * @return the seller
     */
    Seller save(Seller seller);

    /**
     * Update seller.
     *
     * @param seller the seller
     * @return the seller
     */
    Seller update(Seller seller);

    /**
     * Delete.
     *
     * @param seller the seller
     */
    void delete(Seller seller);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
