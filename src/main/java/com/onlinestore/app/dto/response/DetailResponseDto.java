package com.onlinestore.app.dto.response;

import com.onlinestore.app.dto.CarDto;
import com.onlinestore.app.dto.StockDto;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Detail response dto.
 */
public class DetailResponseDto {

    private Long id;

    private String name;

    private String type;

    private Double price;

    private CarDto car;

    private Set<StockDto> stocks = new HashSet<>();

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
     * Gets car.
     *
     * @return the car
     */
    public CarDto getCar() {
        return car;
    }

    /**
     * Sets car.
     *
     * @param car the car
     */
    public void setCar(CarDto car) {
        this.car = car;
    }

    /**
     * Gets stocks.
     *
     * @return the stocks
     */
    public Set<StockDto> getStocks() {
        return stocks;
    }

    /**
     * Sets stocks.
     *
     * @param stocks the stocks
     */
    public void setStocks(Set<StockDto> stocks) {
        this.stocks = stocks;
    }
}
