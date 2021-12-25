package com.onlinestore.app.service;

import com.onlinestore.app.model.Detail;

import java.util.List;

/**
 * The interface Detail service.
 */
public interface DetailService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Detail> findAll();

    /**
     * Find by id detail.
     *
     * @param id the id
     * @return the detail
     */
    Detail findById(Long id);

    /**
     * Save detail.
     *
     * @param detail the detail
     * @return the detail
     */
    Detail save(Detail detail);

    /**
     * Update detail.
     *
     * @param detail the detail
     * @return the detail
     */
    Detail update(Detail detail);

    /**
     * Delete.
     *
     * @param detail the detail
     */
    void delete(Detail detail);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
