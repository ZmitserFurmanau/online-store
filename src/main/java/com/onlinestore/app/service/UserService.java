package com.onlinestore.app.service;

import com.onlinestore.app.model.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> findAll();

    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
    User findById(Long id);

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);

    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    User save(User user);

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    User update(User user);

    /**
     * Delete.
     *
     * @param user the user
     */
    void delete(User user);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
