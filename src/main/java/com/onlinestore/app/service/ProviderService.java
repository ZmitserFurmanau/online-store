package com.onlinestore.app.service;

import com.onlinestore.app.model.Provider;

import java.util.List;

/**
 * The interface Provider service.
 */
public interface ProviderService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Provider> findAll();

    /**
     * Find by id provider.
     *
     * @param id the id
     * @return the provider
     */
    Provider findById(Long id);

    /**
     * Save provider.
     *
     * @param provider the provider
     * @return the provider
     */
    Provider save(Provider provider);

    /**
     * Update provider.
     *
     * @param provider the provider
     * @return the provider
     */
    Provider update(Provider provider);

    /**
     * Delete.
     *
     * @param provider the provider
     */
    void delete(Provider provider);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
