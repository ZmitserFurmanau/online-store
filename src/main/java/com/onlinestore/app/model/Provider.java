package com.onlinestore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Provider.
 */
@Entity
@Table(name = "providers", schema = "public")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{provider.name.notNull}")
    @NotEmpty(message = "{provider.name.notEmpty}")
    private String name;

    /**
     * Instantiates a new Provider.
     */
    public Provider() {
    }

    /**
     * Instantiates a new Provider.
     *
     * @param name the name
     */
    public Provider(final String name) {
        this.name = name;
    }

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
}