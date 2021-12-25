package com.onlinestore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Stock.
 */
@Entity
@Table(name = "stocks", schema = "public")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{stock.quantity.notNull}")
    @NotEmpty(message = "{stock.quantity.notEmpty}")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "provider_id", nullable = false)
    @NotNull(message = "{stock.provider.notNull}")
    private Provider provider;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "heaver_id", nullable = false)
    @NotNull(message = "{stock.heaver.notNull}")
    private Heaver heaver;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "stocks")
    private Set<Detail> details = new HashSet<>();

    /**
     * Instantiates a new Stock.
     */
    public Stock() {
    }

    /**
     * Instantiates a new Stock.
     *
     * @param quantity the quantity
     * @param provider the provider
     * @param heaver   the heaver
     */
    public Stock(final Integer quantity, final Provider provider, final Heaver heaver) {
        this.quantity = quantity;
        this.provider = provider;
        this.heaver = heaver;
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
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets provider.
     *
     * @return the provider
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * Sets provider.
     *
     * @param provider the provider
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * Gets heaver.
     *
     * @return the heaver
     */
    public Heaver getHeaver() {
        return heaver;
    }

    /**
     * Sets heaver.
     *
     * @param heaver the heaver
     */
    public void setHeaver(Heaver heaver) {
        this.heaver = heaver;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public Set<Detail> getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(Set<Detail> details) {
        this.details = details;
    }
}