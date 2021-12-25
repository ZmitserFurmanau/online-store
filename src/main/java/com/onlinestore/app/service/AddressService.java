package com.onlinestore.app.service;

import com.onlinestore.app.model.Address;

import java.util.List;

/**
 * The interface Address service.
 */
public interface AddressService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Address> findAll();

    /**
     * Find by id address.
     *
     * @param id the id
     * @return the address
     */
    Address findById(Long id);

    /**
     * Save address.
     *
     * @param address the address
     * @return the address
     */
    Address save(Address address);

    /**
     * Update address.
     *
     * @param address the address
     * @return the address
     */
    Address update(Address address);

    /**
     * Delete.
     *
     * @param address the address
     */
    void delete(Address address);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
