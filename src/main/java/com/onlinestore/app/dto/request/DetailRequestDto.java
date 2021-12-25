package com.onlinestore.app.dto.request;

import java.util.Set;

/**
 * The type Detail request dto.
 */
public class DetailRequestDto {

    private Long id;

    private String name;

    private String type;

    private Double price;

    private Long carId;

    private Set<Long> stockId;

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
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets car id.
     *
     * @return the car id
     */
    public Long getCarId() {
        return carId;
    }

    /**
     * Sets car id.
     *
     * @param carId the car id
     */
    public void setCarId(Long carId) {
        this.carId = carId;
    }

    /**
     * Gets stock id.
     *
     * @return the stock id
     */
    public Set<Long> getStockId() {
        return stockId;
    }

    /**
     * Sets stock id.
     *
     * @param stockId the stock id
     */
    public void setStockId(Set<Long> stockId) {
        this.stockId = stockId;
    }
}
