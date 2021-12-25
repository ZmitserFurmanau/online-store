package com.onlinestore.app.repository;

import com.onlinestore.app.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Detail repository.
 */
public interface DetailRepository extends JpaRepository<Detail, Long> {

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name detail.
     *
     * @param name the name
     * @return the detail
     */
    Detail findByName(String name);
}
