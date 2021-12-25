package com.onlinestore.app.repository;

import com.onlinestore.app.model.Heaver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Heaver repository.
 */
public interface HeaverRepository extends JpaRepository<Heaver, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name heaver.
     *
     * @param name the name
     * @return the heaver
     */
    Heaver findByName(String name);
}
