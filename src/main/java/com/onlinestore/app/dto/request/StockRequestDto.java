package com.onlinestore.app.dto.request;

import java.util.Set;

/**
 * The type Stock request dto.
 */
public class StockRequestDto {

    private Long id;

    private Integer quantity;

    private Long providerId;

    private Long heaverId;

    private Set<Long> detailId;

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
     * Gets provider id.
     *
     * @return the provider id
     */
    public Long getProviderId() {
        return providerId;
    }

    /**
     * Sets provider id.
     *
     * @param providerId the provider id
     */
    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    /**
     * Gets heaver id.
     *
     * @return the heaver id
     */
    public Long getHeaverId() {
        return heaverId;
    }

    /**
     * Sets heaver id.
     *
     * @param heaverId the heaver id
     */
    public void setHeaverId(Long heaverId) {
        this.heaverId = heaverId;
    }

    /**
     * Gets detail id.
     *
     * @return the detail id
     */
    public Set<Long> getDetailId() {
        return detailId;
    }

    /**
     * Sets detail id.
     *
     * @param detailId the detail id
     */
    public void setDetailId(Set<Long> detailId) {
        this.detailId = detailId;
    }
}
