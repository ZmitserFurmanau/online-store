package com.onlinestore.app.repository;

import com.onlinestore.app.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Seller repository.
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name seller.
     *
     * @param name the name
     * @return the seller
     */
    Seller findByName(String name);
}
