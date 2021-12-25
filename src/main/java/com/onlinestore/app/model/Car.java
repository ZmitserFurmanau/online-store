package com.onlinestore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Car.
 */
@Entity
@Table(name = "cars", schema = "public")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{car.model.notNull}")
    @NotEmpty(message = "{car.model.notEmpty}")
    private String model;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{car.year.notNull}")
    @NotEmpty(message = "{car.year.notEmpty}")
    private Short year;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{car.pinCode.notNull}")
    @NotEmpty(message = "{car.pinCode.notEmpty}")
    private String pinCode;

    /**
     * Instantiates a new Car.
     */
    public Car() {
    }

    /**
     * Instantiates a new Car.
     *
     * @param model   the model
     * @param year    the year
     * @param pinCode the pin code
     */
    public Car(final String model, final Short year, final String pinCode) {
        this.model = model;
        this.year = year;
        this.pinCode = pinCode;
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
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public Short getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(Short year) {
        this.year = year;
    }

    /**
     * Gets pin code.
     *
     * @return the pin code
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * Sets pin code.
     *
     * @param pinCode the pin code
     */
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}