package com.onlinestore.app.dto.request;

import java.time.LocalDateTime;

/**
 * The type Order request dto.
 */
public class OrderRequestDto {

    private Long id;

    private LocalDateTime date;

    private Integer sum;

    private Long sellerId;

    private Long detailId;

    private Long stockId;

    private Long customerId;

    private Long addressId;

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
     * Gets date.
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets sum.
     *
     * @return the sum
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * Sets sum.
     *
     * @param sum the sum
     */
    public void setSum(Integer sum) {
        this.sum = sum;
    }

    /**
     * Gets seller id.
     *
     * @return the seller id
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * Sets seller id.
     *
     * @param sellerId the seller id
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * Gets details stocks id.
     *
     * @return the details stocks id
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * Sets detail id.
     *
     * @param detailId the detail id
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    /**
     * Gets stock id.
     *
     * @return the stock id
     */
    public Long getStockId() {
        return stockId;
    }

    /**
     * Sets stock id.
     *
     * @param stockId the stock id
     */
    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets address id.
     *
     * @return the address id
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * Sets address id.
     *
     * @param addressId the address id
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
