package com.onlinestore.app.repository;

import com.onlinestore.app.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Provider repository.
 */
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name provider.
     *
     * @param name the name
     * @return the provider
     */
    Provider findByName(String name);
}
