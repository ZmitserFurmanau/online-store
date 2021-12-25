package com.onlinestore.app.service;

import com.onlinestore.app.model.Role;

import java.util.List;

/**
 * The interface Role service.
 */
public interface RoleService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Role> findAll();

    /**
     * Find by id role.
     *
     * @param id the id
     * @return the role
     */
    Role findById(Long id);

    /**
     * Find by name role.
     *
     * @param name the name
     * @return the role
     */
    Role findByName(String name);

    /**
     * Save role.
     *
     * @param role the role
     * @return the role
     */
    Role save(Role role);

    /**
     * Update role.
     *
     * @param role the role
     * @return the role
     */
    Role update(Role role);

    /**
     * Delete.
     *
     * @param role the role
     */
    void delete(Role role);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
