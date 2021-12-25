package com.onlinestore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Detail.
 */
@Entity
@Table(name = "details", schema = "public")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{detail.name.notNull}")
    @NotEmpty(message = "{detail.name.notEmpty}")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{detail.type.notNull}")
    @NotEmpty(message = "{detail.type.notEmpty}")
    private String type;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{detail.price.notNull}")
    @NotEmpty(message = "{detail.price.notEmpty}")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    @NotNull(message = "{detail.car.notNull}")
    private Car car;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "details_stocks",
            joinColumns = @JoinColumn(name = "detail_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id"))
    @NotNull(message = "{detail.stocks.notNull}")
    private Set<Stock> stocks = new HashSet<>();

    /**
     * Instantiates a new Detail.
     */
    public Detail() {
    }

    /**
     * Instantiates a new Detail.
     *
     * @param name  the name
     * @param type  the type
     * @param price the price
     * @param car   the car
     */
    public Detail(final String name, final String type, final Double price, final Car car) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.car = car;
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
    public Car getCar() {
        return car;
    }

    /**
     * Sets car.
     *
     * @param car the car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Gets stocks.
     *
     * @return the stocks
     */
    public Set<Stock> getStocks() {
        return stocks;
    }

    /**
     * Sets stocks.
     *
     * @param stocks the stocks
     */
    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}