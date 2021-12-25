package com.onlinestore.app.repository;

import com.onlinestore.app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Address repository.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * Exists by phone number boolean.
     *
     * @param phoneNumber the phone number
     * @return the boolean
     */
    boolean existsByPhoneNumber(Integer phoneNumber);

    /**
     * Find by phone number address.
     *
     * @param phoneNumber the phone number
     * @return the address
     */
    Address findByPhoneNumber(Integer phoneNumber);
}
