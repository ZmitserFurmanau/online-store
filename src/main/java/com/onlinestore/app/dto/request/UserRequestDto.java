package com.onlinestore.app.dto.request;

import java.util.Set;

/**
 * The type User request dto.
 */
public class UserRequestDto {

    private Long id;

    private String name;

    private String password;

    private Set<Long> roleIds;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets role ids.
     *
     * @return the role ids
     */
    public Set<Long> getRoleIds() {
        return roleIds;
    }

    /**
     * Sets role ids.
     *
     * @param roleIds the role ids
     */
    public void setRoleIds(Set<Long> roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
