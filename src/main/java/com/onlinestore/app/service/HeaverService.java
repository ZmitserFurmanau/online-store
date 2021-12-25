package com.onlinestore.app.service;

import com.onlinestore.app.model.Heaver;

import java.util.List;

/**
 * The interface Heaver service.
 */
public interface HeaverService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Heaver> findAll();

    /**
     * Find by id heaver.
     *
     * @param id the id
     * @return the heaver
     */
    Heaver findById(Long id);

    /**
     * Save heaver.
     *
     * @param heaver the heaver
     * @return the heaver
     */
    Heaver save(Heaver heaver);

    /**
     * Update heaver.
     *
     * @param heaver the heaver
     * @return the heaver
     */
    Heaver update(Heaver heaver);

    /**
     * Delete.
     *
     * @param heaver the heaver
     */
    void delete(Heaver heaver);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
