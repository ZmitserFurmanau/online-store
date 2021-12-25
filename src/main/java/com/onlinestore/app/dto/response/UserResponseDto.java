package com.onlinestore.app.dto.response;

import com.onlinestore.app.dto.RoleDto;

import java.util.HashSet;
import java.util.Set;

/**
 * The type User response dto.
 */
public class UserResponseDto {

    private Long id;

    private String name;

    private Set<RoleDto> roles = new HashSet<>();

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
     * Gets roles.
     *
     * @return the roles
     */
    public Set<RoleDto> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }
}
